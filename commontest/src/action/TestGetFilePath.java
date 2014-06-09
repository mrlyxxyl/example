package action;

import java.io.IOException;
import java.io.InputStream;

public class TestGetFilePath {
    public static void main(String[] args) throws IOException {
        InputStream is = TestGetFilePath.class.getResourceAsStream("/cfg.properties");
        byte buf[] = new byte[1024];
        int len;
        while ((len = is.read(buf)) > 0) {
            String s = new String(buf, 0, len);
            System.out.println(s);
        }
    }
}
