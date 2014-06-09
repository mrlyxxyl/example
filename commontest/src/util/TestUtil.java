package util;

public class TestUtil {
    public static void main(String[] args) {
        test1("fcscsa");

    }

    public static void test(String str) {
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i] + " ");
        }
        System.out.println();
    }

    public static void test1(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    public static void testDate() {
    }
}
