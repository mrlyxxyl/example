import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-10-26
 * Time: обнГ1:02
 * To change this template use File | Settings | File Templates.
 */
public class TestDate {
    public static void main(String[] args) {
        Date endDate = new Date();
        endDate.setDate(endDate.getDate() + 365);
        System.out.println(endDate.toLocaleString());

    }
}
