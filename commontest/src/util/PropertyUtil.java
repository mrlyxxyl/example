package util;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    private static Properties property;

    static {
        property = new Properties();
        try {
            property.load(PropertyUtil.class.getClassLoader().getResourceAsStream("cfg.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Œ¥’“µΩ≈‰÷√Œƒº˛cfg.properties" + e.getMessage());
        }
    }

    public static String getValue(String key) {
        return property.getProperty(key);
    }
}
