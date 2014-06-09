package action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestEncoder {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String urlStr = "ÀîÎÄ³¬";
        String dd = URLEncoder.encode(urlStr, "utf-8");
        String ddddd = URLDecoder.decode(dd, "utf-8");
        System.out.println(dd + "   " + ddddd);
    }
}
