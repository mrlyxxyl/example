package action;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFMUBAN {

    public static void main(String[] args) {
        String tempPath = PDFMUBAN.class.getClassLoader().getResource("excelpdf.pdf").getPath();
        try {
            FileOutputStream fos = new FileOutputStream("e:/excelpdftes.pdf");
            PdfReader pdfReader = new PdfReader(tempPath);
            PdfStamper pdfStamper = new PdfStamper(pdfReader,fos);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
