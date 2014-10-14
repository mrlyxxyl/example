package action;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class TestFTPMain {
    public static void upload() {
        TestFTP remote = new TestFTP();
        FTPClient ftpClient = remote.loginFtp("192.168.137.1", 21, "nanmeiying", "root");
        try {
            remote.uploadDirFiles("E:\\mysql_bak", "//");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void download() {
        TestFTP remote = new TestFTP();
        FTPClient ftpClient = remote.loginFtp("192.168.137.1", 21, "nanmeiying", "root");
        try {
            remote.downloadDirFiles("\\mysql_bak", "f://", "mysql_bak");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        upload();
    }
}
