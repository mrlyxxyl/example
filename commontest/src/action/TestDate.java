package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse("2013-02-02");
            System.out.println(date.toLocaleString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
