package action;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        ProgressMonitorInputStream monitor;
        monitor = new ProgressMonitorInputStream(null, "�ļ��ϴ���...", new FileInputStream("f:\\test.bhd"));
        int all = monitor.available();//�����ļ��Ĵ�С
        ProgressMonitor progressMonitor = new ProgressMonitor(null, "message", "note", 0, all);
        byte[] buff = new byte[2048];
        int in;//ÿ�ζ�ȡ�ļ��Ĵ�С
        int readed = 0;//��ʾ�Ѿ���ȡ���ļ�
        while ((in = monitor.read(buff)) > 0) {
            readed += in;//�ۼӶ�ȡ�ļ���С
            float process = (float) readed / all * 100;// ����ٷֱ�
            progressMonitor.setNote("archived " + process + " %");// ��ʾ�ڽ�������
        }
    }
}
