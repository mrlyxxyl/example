package action;

import java.util.Enumeration;
import java.util.Properties;

public class TestInput {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Enumeration enumeration = properties.propertyNames();
        String sysKey;
        String sysVal;
        while (enumeration.hasMoreElements()) {
            sysKey = enumeration.nextElement().toString();
            sysVal = System.getProperty(sysKey);
            System.out.println("key:" + sysKey + "\t\t\t\t\t\t\t\tVal:" + sysVal);
        }
    }

}
