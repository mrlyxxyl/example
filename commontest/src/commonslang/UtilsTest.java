package commonslang;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UtilsTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com/");
        URLConnection conn = url.openConnection();
        InputStream inputStream = conn.getInputStream();
        FileOutputStream fos = new FileOutputStream("d:/test.html");
        int len;
        byte[] buff = new byte[1024];
        while ((len = inputStream.read(buff)) > 0) {
            fos.write(buff, 0, len);
        }
        fos.close();
    }
}
