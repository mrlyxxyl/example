package action;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 2000, 10000);
        while (true) {
            try {
                int ch = System.in.read();
                if (ch - 'c' == 0) {
                    timer.cancel();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
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

    static class MyTask extends TimerTask {
        @Override
        public void run() {
            File file = new File("f:/test");
            deleteFile(file);
        }
    }
}
