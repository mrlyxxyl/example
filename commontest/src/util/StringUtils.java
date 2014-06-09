package util;

import java.io.UnsupportedEncodingException;

public class StringUtils {
    public static String pad4ChineseToByteLength(boolean isLeftPad, String srcStr, int totalByteLength, String padStr) {
        if (srcStr == null) {
            return null;
        }
        int srcByteLength = srcStr.getBytes().length;

        if (padStr == null || "".equals(padStr)) {
            padStr = " ";
        } else if (padStr.getBytes().length > 1 || totalByteLength <= 0) {
            throw new RuntimeException("²ÎÊý´íÎó");
        }
        StringBuilder rtnStrBuilder = new StringBuilder();
        if (totalByteLength >= srcByteLength) {
            if (isLeftPad) {   // ×ó²¹
                for (int i = 0; i < totalByteLength - srcByteLength; i++) {
                    rtnStrBuilder.append(padStr);
                }
                rtnStrBuilder.append(srcStr);
            } else {        // ÓÒ²¹
                rtnStrBuilder.append(srcStr);
                for (int i = 0; i < totalByteLength - srcByteLength; i++) {
                    rtnStrBuilder.append(padStr);
                }
            }
        } else {
            byte[] rtnBytes = new byte[totalByteLength];
            try {
                System.arraycopy(srcStr.getBytes("GBK"), 0, rtnBytes, 0, totalByteLength);
                rtnStrBuilder.append(new String(rtnBytes, "GBK"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return rtnStrBuilder.toString();
    }


    public static void main(String[] args) {
        String ss = pad4ChineseToByteLength(true, "ÄãºÃ°¡", 20, " ");
        String ss1 = pad4ChineseToByteLength(false, "ÄãºÃ°¡", 20, " ");
        System.out.println(ss + ss1);
        System.out.println(ss1 + ss);
    }
}
