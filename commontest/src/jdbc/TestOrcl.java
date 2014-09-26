package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestOrcl {

    public static void main(String[] args) {
        System.out.println(getss().size());
    }

    public static List<String> getss(){
        Connection connection;
        Statement statement;
        ResultSet rs;
        List<String> strings = new ArrayList<String>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "yuexin", "yuexin");
            statement = connection.createStatement();
            String sql = "select * from people";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                strings.add(rs.getString("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
