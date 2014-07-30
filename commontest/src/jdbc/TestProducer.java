package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestProducer {

    public static void main(String[] args) {
        getss();
    }

    public static List<String> getss() {
        Connection connection;
        CallableStatement statement;
        ResultSet rs;
        List<String> strings = new ArrayList<String>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "yuexin", "yuexin");
            statement = connection.prepareCall("{call testc(?)}");
            statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            statement.execute();
            rs = (ResultSet) statement.getObject(1);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
