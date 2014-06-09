/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-10-28
 * Time: обнГ6:19
 * To change this template use File | Settings | File Templates.
 */
public class TestHash {
    public static void main(String[] args) {
        try {
            method();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void method() throws Exception {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new MyException();
        }
    }
}
