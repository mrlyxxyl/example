package date4j;

import hirondelle.date4j.DateTime;

public class Date4jTest {
    public static void main(String[] args) {
        DateTime dateAndTime = new DateTime("2010-01-19 23:59:59");
        dateAndTime = new DateTime("2010-01-19 23:59:59.123456789");
        DateTime dateOnly = new DateTime("2010-01-19");
        DateTime timeOnly = new DateTime("23:59:59");
        dateOnly = DateTime.forDateOnly(2010, 01, 19);
        timeOnly = DateTime.forTimeOnly(23, 59, 59, 0);

        DateTime dt = new DateTime("2010-01-15 13:59:15");
        boolean leap = dt.isLeapYear(); //false
        System.out.println(leap);
        System.out.println(dt.getNumDaysInMonth());
        System.out.println(dt.format("YYYY-MM-DD"));
        dt.getNumDaysInMonth(); //31

        dt.getStartOfMonth(); //2010-01-01, 00:00:00.000000000
        dt.getEndOfDay(); //2010-01-15, 23:59:59.999999999
        dt.format("YYYY-MM-DD"); //formats as '2010-01-15'
        dt.plusDays(30); //30 days after Jan 15
        dt.numDaysFrom(dateOnly); //returns an int
        dt.lt(dateOnly); //less-than
        dt.lteq(dateOnly); //less-than-or-equal-to
    }
}
