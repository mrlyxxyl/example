package action;

import java.io.*;

public class ReadPDF {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("e:/excelpdf.pdf");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String str;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
    }
}
