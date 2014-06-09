package action;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestMD5 {

    public static void main(String[] args) {
        /*System.setProperty("hello","haha");
        System.out.println(System.getProperty("hello"));*/

        String dd = "À≠À≠À≠À≠À≠À≠";
        try {
            System.out.println(myMD(dd));
            System.out.println(getMD5(dd));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static String myMD(String str) throws NoSuchAlgorithmException {
        if (str != null || "".equals(str)) {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            return new String(md5.digest(str.getBytes()));
        }
        return str;
    }

    /**
     * md5º”√‹
     *
     * @param str
     * @return
     * @throws java.security.NoSuchAlgorithmException
     *
     */
    public static String getMD5(String str) throws NoSuchAlgorithmException {
        if (str != null || "".equals(str)) {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            return base64en.encode(md5.digest(str.getBytes()));
        }
        return str;
    }
}
