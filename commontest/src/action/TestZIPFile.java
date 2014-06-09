package action;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class TestZIPFile {
    public static void main(String[] args) {
        try {
            ZipFile zipFile = new ZipFile("f:/test2.zip");
            Enumeration enumeration = zipFile.entries();
            while (enumeration.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) enumeration.nextElement();
                System.out.println(entry.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
