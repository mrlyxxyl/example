package action;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) throws IOException {

        File file = new File("g:/test/test1.txt");
        file.renameTo(new File("g:/test/test.txt"));
        /*String[] files = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.contains("j")) return true;
                return false;
            }
        });*/
       /* System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separator);
        System.out.println(File.separatorChar);*/

    }
}
