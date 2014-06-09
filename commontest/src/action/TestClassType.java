package action;

import java.lang.reflect.Field;

public class TestClassType {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("beanCopy.People");
            System.out.println(clazz);
            Field field = clazz.getDeclaredField("name");
            System.out.println(field.getType());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
