package action;

import java.util.HashMap;
import java.util.Map;

public class FigureAndChinese2Util {

    // �����������ֵ�
    private static Map<Character, Character> map = new HashMap<Character, Character>(
            10);
    static {
        map.put('1', 'Ҽ');
        map.put('2', '��');
        map.put('3', '��');
        map.put('4', '��');
        map.put('5', '��');
        map.put('6', '½');
        map.put('7', '��');
        map.put('8', '��');
        map.put('9', '��');
        map.put('0', '��');
    }
    static char[] mode = new char[] { 'ʰ', '��', 'Ǫ' };

    public static void m(String sb) {

        StringBuffer sbf = new StringBuffer();
        String[] sp = sb.split("\\.");
        if (sp.length == 2) {
            m0(sp[0], 0, sbf);
            sbf.append(m2(sp[1]));
        } else
            m0(sb, 0, sbf);
        sbf.append("��");
        System.out.println(sbf);
    }

    /***
     * �и��ַ���
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
        if ('��' == sbf.charAt(0))
            sbf.deleteCharAt(0);
    }

    /***
     * ����
     *
     * @param sb
     */
    public static StringBuffer m1(String sb, int type) {

        StringBuffer sbf = new StringBuffer(sb);
        switch (type) {
            case 1:
                sbf.append("Բ");
                break;
            case 2:
                sbf.append("��");
                break;
            case 3:
                sbf.append("��");
                break;
            default:
                break;
        }
        // ��ʼ��ֵ
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
            if (t == '��') {
                t = sbf.charAt(i + 1);
                if ('Բ' != t && '��' != t && '��' != t)
                    sbf.deleteCharAt(i + 1);
                else
                    sbf.deleteCharAt(i);
                if (i != 0)
                    if (sbf.charAt(i - 1) == '��') {
                        sbf.deleteCharAt(i - 1);
                        i--;
                    }
            }
        }
        if (sbf.length() == 1) {
            if ('Բ' != sbf.charAt(0))
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
                    sb.append("��");
                    break;
                case 2:
                    sb.setCharAt(1, map.get(sb.charAt(1)));
                    if (sb.charAt(0) != '��')
                        sb.insert(1, '��');
                    sb.append("��");
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