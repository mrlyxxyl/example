package action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-5-14
 * Time: ÉÏÎç8:59
 * To change this template use File | Settings | File Templates.
 */
public class TestTry {
    public static void main(String[] args) {
        System.out.println(test());
    }


    public static boolean test(){

        try {
            FileInputStream fis = new FileInputStream("e:\\test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("flsajfl");
        System.out.println("flsajfl");
        System.out.println("flsajfl");
        System.out.println("flsajfl");
        System.out.println("flsajfl");
        System.out.println("flsajfl");
        return true;
    }
}
