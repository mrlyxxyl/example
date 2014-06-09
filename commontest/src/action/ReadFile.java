package action;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        ProgressMonitorInputStream monitor;
        monitor = new ProgressMonitorInputStream(null, "文件上传中...", new FileInputStream("f:\\test.bhd"));
        int all = monitor.available();//整个文件的大小
        ProgressMonitor progressMonitor = new ProgressMonitor(null, "message", "note", 0, all);
        byte[] buff = new byte[2048];
        int in;//每次读取文件的大小
        int readed = 0;//表示已经读取的文件
        while ((in = monitor.read(buff)) > 0) {
            readed += in;//累加读取文件大小
            float process = (float) readed / all * 100;// 算出百分比
            progressMonitor.setNote("archived " + process + " %");// 显示在进度条上
        }
    }
}
