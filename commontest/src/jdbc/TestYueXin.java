package jdbc;

import action.GenerateRandomNumber;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.UUID;

public class TestYueXin {

    public static void main(String[] args) throws IOException {
        Connection connection;
        Statement statement;
        ResultSet rs;
        ResultSetMetaData rsmd;
        DatabaseMetaData dmd;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "yuexin", "yuexin");
            String upStr = "update testb set id = '"+UUID.randomUUID().toString()+"'";
            statement = connection.createStatement();
            statement.executeUpdate(upStr);
//            String insql = "insert into testb (id,name) select '" + UUID.randomUUID().toString() + "',name from testa";
//            statement = connection.createStatement();
//            statement.execute(insql);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
