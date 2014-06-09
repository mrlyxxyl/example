package action;

import java.util.Enumeration;
import java.util.Properties;

public class TestSystem {
    public static void main(String[] args) {
        Properties propertieses = System.getProperties();
        Enumeration enumeration = propertieses.propertyNames();
        while (enumeration.hasMoreElements()) {
            String e = (String) enumeration.nextElement();
            // System.out.println(e + "-----------------" + propertieses.getProperty(e));
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());



        Properties properties = System.getProperties();
        enumeration = properties.propertyNames();
        String sysKey;
        String sysVal;
        while (enumeration.hasMoreElements()) {
            sysKey = enumeration.nextElement().toString();
            sysVal = System.getProperty(sysKey);
            System.out.println("key:" + sysKey + "\t\t\t\t\t\t\t\tVal:" + sysVal);
        }
        String temp = System.getProperty("file.encoding");
        System.out.println(temp);

    }
}
