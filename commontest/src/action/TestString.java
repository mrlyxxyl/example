package action;

public class TestString {
    public static void main(String[] args) {
       String str = "ddddd;";
        str = str.substring(0,str.lastIndexOf(";")) ;

        System.out.println(str);
    }

    /**
     * 将字符串中的第一个字母变为大写
     *
     * @param str
     * @return
     */
    public static String changeFirstLetterUpperCase(String str) {
        if (str == null || "".equals(str.trim())) {
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
}
