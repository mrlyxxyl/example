package action;

import java.util.HashMap;
import java.util.Map;

public class FigureAndChinese2Util {

    // »º´æËùÓÐÊý×ÖµÄ
    private static Map<Character, Character> map = new HashMap<Character, Character>(
            10);
    static {
        map.put('1', 'Ò¼');
        map.put('2', '·¡');
        map.put('3', 'Èþ');
        map.put('4', 'ËÁ');
        map.put('5', 'Îé');
        map.put('6', 'Â½');
        map.put('7', 'Æâ');
        map.put('8', '°Æ');
        map.put('9', '¾Á');
        map.put('0', 'Áã');
    }
    static char[] mode = new char[] { 'Ê°', '°Û', 'Çª' };

    public static void m(String sb) {

        StringBuffer sbf = new StringBuffer();
        String[] sp = sb.split("\\.");
        if (sp.length == 2) {
            m0(sp[0], 0, sbf);
            sbf.append(m2(sp[1]));
        } else
            m0(sb, 0, sbf);
        sbf.append("Õû");
        System.out.println(sbf);
    }

    /***
     * ÇÐ¸î×Ö·û´®
     *
     * @param sb
     */
    public static void m0(String sb, int type, StringBuffer sbf) {

        int len = sb.length();
        int b = 0;
        type++;
        if (len >= 4) {
            b = len - 4;
            sbf.insert(0, m1(sb.substring(b), type));
            m0(sb.substring(0, b), type, sbf);
        } else if (len > 0)
            sbf.insert(0, m1(sb, type));
        if ('Áã' == sbf.charAt(0))
            sbf.deleteCharAt(0);
    }

    /***
     * ´¦Àí
     *
     * @param sb
     */
    public static StringBuffer m1(String sb, int type) {

        StringBuffer sbf = new StringBuffer(sb);
        switch (type) {
            case 1:
                sbf.append("Ô²");
                break;
            case 2:
                sbf.append("Íò");
                break;
            case 3:
                sbf.append("ÒÚ");
                break;
            default:
                break;
        }
        // ¿ªÊ¼¸³Öµ
        int b = 0;
        char t = 0;
        for (int i = sbf.length() - 2; i >= 0; i--) {
            t = sbf.charAt(i);
            sbf.setCharAt(i, map.get(t));
            if (i != 0)
                sbf.insert(i, mode[b]);
            b++;
        }
        for (int i = 0; i < sbf.length(); i++) {
            t = sbf.charAt(i);
            if (t == 'Áã') {
                t = sbf.charAt(i + 1);
                if ('Ô²' != t && 'Íò' != t && 'ÒÚ' != t)
                    sbf.deleteCharAt(i + 1);
                else
                    sbf.deleteCharAt(i);
                if (i != 0)
                    if (sbf.charAt(i - 1) == 'Áã') {
                        sbf.deleteCharAt(i - 1);
                        i--;
                    }
            }
        }
        if (sbf.length() == 1) {
            if ('Ô²' != sbf.charAt(0))
                sbf.setLength(0);
        }
        return sbf;
    }

    public static StringBuffer m2(String de) {

        if (de.length() > 2)
            de = de.substring(0, 2);
        de = de.replaceFirst("00", "");
        StringBuffer sb = new StringBuffer(de);
        if (sb.length() > 0) {
            if (sb.charAt(sb.length() - 1) == '0')
                sb.deleteCharAt(sb.length() - 1);
            sb.setCharAt(0, map.get(sb.charAt(0)));
            switch (sb.length()) {
                case 1:
                    sb.append("½Ç");
                    break;
                case 2:
                    sb.setCharAt(1, map.get(sb.charAt(1)));
                    if (sb.charAt(0) != 'Áã')
                        sb.insert(1, '½Ç');
                    sb.append("·Ö");
                    break;
                default:
                    break;
            }
        }
        return sb;
    }

    public static void main(String[] args) {

        String s = "4444444441.23";
        String s1 = "1";
        String s2 = "1000000000.01";
        String s3 = "101010002.11";
        m(s);
        m(s1);
        m(s2);
        m(s3);
    }
}