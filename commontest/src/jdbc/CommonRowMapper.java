package rowmapper;

import org.springframework.jdbc.core.RowMapper;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonRowMapper implements RowMapper {
    private Class clazz;

    public CommonRowMapper(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Object obj = null;
        try {
            obj = clazz.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                propertyDescriptor.getWriteMethod().invoke(obj, resultSet.getObject(propertyDescriptor.getName()));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
