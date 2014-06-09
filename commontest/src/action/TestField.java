package action;

import beanCopy.People;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestField {
    public static void main(String[] args) {
        Class clazz = People.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
//            System.out.println(field.getName());
        }

        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
//            System.out.println(m.getName());
        }

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : descriptors) {
                System.out.println(descriptor.getName());
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
