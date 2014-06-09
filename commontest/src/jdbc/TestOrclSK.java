package jdbc;

import java.sql.*;
import java.util.UUID;

public class TestOrclSK {

    public static void main(String[] args) {
        Connection connection;
        Statement statement;
        ResultSet rs;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "sk", "sk");
            statement = connection.createStatement();
            String sql = "insert into inv_intdata (pkid,custcode,custname,custype,txndate,intamt,txntype,currencytype,iounum,recver,itemstate) select  " + UUID.randomUUID().toString() + ",t.csm_code,t.csm_name,'1',to_char('YYYYMMDD',t.biz_date),t.interest,t.业务类别代码,t.cur_code,t.lnci_no,'1.0','1' from haiernewdata t";
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
