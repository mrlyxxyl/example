package action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestCalander {
    public static void main(String[] args) {
        String txnDateEnd ="201312";
        Calendar calendar = Calendar.getInstance();
        String dd =       txnDateEnd.substring(0,4);
        String ddd =      txnDateEnd.substring(4);
        calendar.set(Calendar.YEAR,Integer.parseInt(dd));
        calendar.set(Calendar.MONTH,Integer.parseInt(ddd));

        System.out.println(new SimpleDateFormat("yyyyMM").format(calendar.getTime()));

    }
}
