package action;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-5-7
 * Time: ����10:12
 * To change this template use File | Settings | File Templates.
 */
public class TestSplit {
    public static void main(String[] args) {
        String str = "�й�    �Ǻ�     ���";
        str = str.replaceAll("\\s+", " ");
        String[] ss = str.split(" ");
        System.out.println(ss.length);
    }
}
