package util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 积累的通用工具
 */
public class CommonUtil {

    /**
     * sql通用日期格式
     */
    public static final String SQLDATETYPE = "yyyy-mm-dd";

    /**
     * 通用日期格式化工具
     */
    public static SimpleDateFormat formatYMD = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat formatYMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat formatHMS = new SimpleDateFormat("HH:mm:ss");

/*--------------------------------------以下是字符串工具---------------------------------------*/

    /**
     * 判断字符串是否为空：null or ""
     */
    public static boolean stringEmpty(String str) {
        return str == null || str.trim().equals("");
    }

    /**
     * 在字符串的前面补上指定的字符到指定的长度
     *
     * @param srcStr 源字符串
     * @param preC   插入字符
     * @param len    指定长度
     * @return
     */
    public static String addPrefix(String srcStr, char preC, int len) {
        if (!stringEmpty(srcStr) && srcStr.length() > len) {
            StringBuffer sb = new StringBuffer(srcStr);
            for (int i = 0; i < len - srcStr.length(); i++) {
                sb.insert(0, preC);
            }
            return sb.toString();
        }
        return srcStr;
    }

    /**
     * 逆置字符串
     *
     * @param srcStr 源字符串
     * @return
     */
    public static String reverseString(String srcStr) {
        if (stringEmpty(srcStr)) {
            return "";
        }
        return new StringBuffer(srcStr).reverse().toString();
    }

    /**
     * 将字符串中的第一个字母变为大写
     *
     * @param str
     * @return
     */
    public static String changeFirstLetterUpperCase(String str) {
        if (stringEmpty(str)) {
            return str;
        }
        char[] chars = str.toCharArray();
        char c;
        for (int i = 0, j = chars.length; i < j; i++) {
            c = chars[i];
            if ((c >= 'A' && c <= 'Z')) {
                break;
            } else if (c >= 'a' && c <= 'z') {
                chars[i] -= 32;
                break;
            }
        }
        return String.valueOf(chars);
    }

    /*--------------------------------------以下是日期工具---------------------------------------*/

    /**
     * 加减月数
     *
     * @param srcDate 源日期
     * @param num     加减月数
     * @return
     */
    public static Date addMonth(Date srcDate, int num) {
        if (srcDate == null) {
            return srcDate;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(srcDate);
        calendar.add(Calendar.MONTH, num);
        return calendar.getTime();
    }

    /**
     * 加减天数
     *
     * @param srcDate 源日期
     * @param num     加减天数
     * @return
     */
    public static Date addDate(Date srcDate, int num) {
        if (srcDate == null) {
            return srcDate;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(srcDate);
        calendar.add(Calendar.DATE, num);
        return calendar.getTime();
    }

    /**
     * 加减年数
     *
     * @param srcDate 源日期
     * @param num     加减年数
     * @return
     */
    public static Date addYear(Date srcDate, int num) {
        if (srcDate == null) {
            return srcDate;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(srcDate);
        calendar.add(Calendar.YEAR, num);
        return calendar.getTime();
    }

    /**
     * 求两个日期间隔天数
     *
     * @param startDate 起始日期
     * @param endDate   结束日期
     * @return
     */
    public static long getDaysBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return 0;
        }
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);
        return (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
    }

    /**
     * 获取指定完整日期字符串
     *
     * @return
     */
    public static String getDateTime(Date srcDate) {
        if (srcDate == null) {
            return "";
        }
        return formatYMDHMS.format(srcDate);
    }

    /**
     * 获取指定日期字符串
     *
     * @return
     */
    public static String getDate(Date srcDate) {
        if (srcDate == null) {
            return "";
        }
        return formatYMD.format(srcDate);
    }

    /**
     * 获取指定时间字符串
     *
     * @return
     */
    public static String getTime(Date srcDate) {
        if (srcDate == null) {
            return "";
        }
        return formatHMS.format(srcDate);
    }

    /**
     * 解析字符串获得日期
     *
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr) throws ParseException {
        return formatYMD.parse(dateStr);
    }


    /*--------------------------------------以下是通用工具---------------------------------------*/

    /**
     * md5加密
     *
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5(String str) throws NoSuchAlgorithmException {
        if (!stringEmpty(str)) {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            return base64en.encode(md5.digest(str.getBytes()));
        }
        return str;
    }


    public static void main(String[] args) {
        String str = "jfdkls";
        System.out.println(changeFirstLetterUpperCase(str));
    }
}
