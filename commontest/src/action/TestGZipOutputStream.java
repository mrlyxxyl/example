package action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class TestGZipOutputStream {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("2");
        System.out.println(sb.toString());
    }

    public static byte[] gzip(String str) throws IOException {
        if (str != null) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzos = new GZIPOutputStream(bos);
            gzos.write(str.getBytes());
            gzos.close();
            return bos.toByteArray();
        }
        return null;
    }

    public static String deGzip(byte[] gzipBuf) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(gzipBuf);
        GZIPInputStream gin = new GZIPInputStream(bis);
        byte[] buff = new byte[1024];
        int len;
        StringBuffer sb = new StringBuffer();
        while ((len = gin.read(buff)) > 0) {
            sb.append(new String(buff, 0, len));
        }
        return sb.toString();
    }
}
