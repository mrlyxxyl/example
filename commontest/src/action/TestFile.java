package action;

import java.io.*;

public class TestFile {

    public static void main(String[] args) throws IOException {
        File srcPath = new File("F:\\custom\\WebRoot");
        listFile(srcPath);

    }

    public static void listFile(File file) throws IOException {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                listFile(file1);

            } else {

                FileInputStream fis = new FileInputStream(file1);
                String filePath = file1.getAbsolutePath();
                filePath = "f:/new1/" + filePath.substring(filePath.indexOf("custom"));

                String temp = filePath.substring(0,filePath.lastIndexOf("\\"));


                File file2 = new File(temp);
                if (!file2.exists()) {
                    file2.mkdirs();
                }

                FileOutputStream fos = new FileOutputStream(filePath);
                byte[] buff = new byte[1024];
                int len;
                while ((len = fis.read(buff)) > 0) {
                    fos.write(buff, 0, len);
                }
                fos.close();
                fis.close();
            }
        }
    }
}
