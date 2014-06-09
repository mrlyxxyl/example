package action;

import java.io.File;

public class DeleteDirectory {
    public static void main(String[] args) {
        File file = new File("f:/test");
        deleteFile(file);
    }

    public static void deleteFile(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                file1 = new File(file1, "/");
                deleteFile(file1);
            }
            file1.delete();
        }
    }
}
