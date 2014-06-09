import java.io.*;

public class DateTrans {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("f:/date.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            FileOutputStream fos = new FileOutputStream("f:/date2.txt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            String temp = "";
            while ((temp = br.readLine()) != null) {

                bw.write(temp + "4");
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
