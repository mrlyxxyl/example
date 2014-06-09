package action;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExportPdfTest {

    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("d:\\itext.pdf"));
            doc.open();
            doc.add(new Paragraph("Hello World"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            doc.close();
        }
    }
}
