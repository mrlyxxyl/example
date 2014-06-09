package action;

import java.io.IOException;

public class TestRuntime {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("D:\\Program Files\\CNTV\\CBox\\CBox.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
