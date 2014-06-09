package converter;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DateTypeConverter extends DefaultTypeConverter {
    @Override
    public Object convertValue(Map<String, Object> context, Object value, Class toType) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        try {
            if (toType == Date.class) {
                String[] params = (String[]) value;
                return format.parse(params[0]);
            } else if (toType == String.class) {
                Date date = (Date) value;
                return format.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
