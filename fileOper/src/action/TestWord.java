package action;

import java.io.FileOutputStream;
import java.net.URL;

public class TestWord {
    public static void main(String[] args) {
        try {

            URL url = TestWord.class.getClassLoader().getResource("testWord.doc");
            FileOutputStream fos = new FileOutputStream(url.getPath());
            fos.write("jfdkslajfldks".getBytes());
            fos.flush();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
