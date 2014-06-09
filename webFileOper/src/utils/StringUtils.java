package utils;

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
            throw new RuntimeException("参数错误");
        }
        StringBuilder rtnStrBuilder = new StringBuilder();
        if (totalByteLength >= srcByteLength) {
            if (isLeftPad) {   // 左补
                for (int i = 0; i < totalByteLength - srcByteLength; i++) {
                    rtnStrBuilder.append(padStr);
                }
                rtnStrBuilder.append(srcStr);
            } else {        // 右补
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
        String dd = strFormat("00000000000");
        System.out.println(dd);
    }


    public static String strFormat(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        double d = Double.parseDouble(str);
        if (d == 0) {
            return "0.000000";
        }
        d = d / 1000000;
        return d + "";
    }

    //本金格式化
    public static String strFormat2(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        str = Long.parseLong(str) + "";
        if ("0".equals(str)) {
            return "0.00";
        }
        StringBuffer sb = new StringBuffer(str);
        char[] chars = sb.reverse().toString().toCharArray();
        StringBuffer tmp = new StringBuffer("");
        for (int i = 0; i < chars.length; i++) {
            tmp.append(chars[i]);
            if (i == 1) {
                tmp.append(".");
            } else if (i % 3 == 1 && i != chars.length - 1) {
                tmp.append(",");
            }
        }
        return tmp.reverse().toString();
    }
}
