package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestMySql {

    public static void main(String[] args) {
        System.out.println(getss().size());
    }

    public static List<String> getss() {
        Connection connection;
        PreparedStatement statement;
        ResultSet rs;
        List<String> strings = new ArrayList<String>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///test", "root", "admin123");
            statement = connection.prepareStatement("insert into ssq (num1,num2,num3,num4,num5,num6,num7) values (?,?,?,?,?,?,?)");
            List<Integer> arrs;
            for (int i = 1; i <= 10000000; i++) {
                arrs = genNum();
                statement.setInt(1, arrs.get(0));
                statement.setInt(2, arrs.get(1));
                statement.setInt(3, arrs.get(2));
                statement.setInt(4, arrs.get(3));
                statement.setInt(5, arrs.get(4));
                statement.setInt(6, arrs.get(5));
                statement.setInt(7, arrs.get(6));
                statement.addBatch();
                if (i % 1000 == 0) {
                    statement.executeBatch();
                }
            }
//select distinct * ,count(*) from ssq group by num1,num2,num3,num4,num5,num6,num7 having count(*) <10;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static List<Integer> genNum() {

        List<Integer> arrs = new ArrayList<Integer>();
        Random random = new Random();
        int num;

        for (int i = 0; i < 6; i++) {
            num = random.nextInt(33) + 1;
            while (true) {
                if (!arrs.contains(num)) {
                    arrs.add(num);
                    break;
                } else {
                    num = random.nextInt(33) + 1;
                }
            }
        }

        Collections.sort(arrs);
        arrs.add(random.nextInt(16) + 1);


        return arrs;
    }

}
