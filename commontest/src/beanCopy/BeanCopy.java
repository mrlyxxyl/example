package beanCopy;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BeanCopy {

    public static Object copyBean(Object src, Object target) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        if (src == null || target == null) {
            return target;
        }
        BeanInfo srcInfo = Introspector.getBeanInfo(src.getClass());
        BeanInfo tarInfo = Introspector.getBeanInfo(target.getClass());
        PropertyDescriptor[] srcpts = srcInfo.getPropertyDescriptors();
        PropertyDescriptor[] tarpts = tarInfo.getPropertyDescriptors();
        for (PropertyDescriptor srcpt : srcpts) {
            for (PropertyDescriptor tarpt : tarpts) {
                if (!"class".equals(srcpt.getName()) && srcpt.getName().equals(tarpt.getName()) && srcpt.getPropertyType().getName().equals(tarpt.getPropertyType().getName())) {
                    tarpt.getWriteMethod().invoke(target, srcpt.getReadMethod().invoke(src, null));
                }
            }
        }
        return target;
    }

    public static void main(String[] args) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("111", "dddd");
        Person person = new Person(1, "nanmeiying", 2, new Date(), map);
        People people = new People();
        people = (People) copyBean(person, people);
    }
}
