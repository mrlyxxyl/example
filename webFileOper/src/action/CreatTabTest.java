package action;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Lichao.W
 * Date: 14-3-17
 * Time: 下午1:13
 * To change this template use File | Settings | File Templates.
 */
public class CreatTabTest {
    public static final String BASE_FONT = "c:/windows/fonts/simsun.ttc,1";

    public static void writePdf() throws IOException, DocumentException {

        String fileName = "d:\\开户模板.pdf"; //
        PdfReader reader = new PdfReader(fileName);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfStamper ps = new PdfStamper(reader, bos);
        /**
         * 使用中文字体 如果是利用 AcroFields填充值的不需要在程序中设置字体，在模板文件中设置字体为中文字体就行了
         */
/*        BaseFont bf = BaseFont.createFont(BASE_FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(bf, 12, Font.NORMAL);*/
        AcroFields s = ps.getAcroFields();
        s.setField("jid", "010");
        s.setField("bid", "60");
        s.setField("id", "9010600");
        s.setField("name", "海尔");
        s.setField("date", "20140317");
        s.setField("pl", "0005");
        ps.setFormFlattening(true);
        ps.close();
        FileOutputStream fos = new FileOutputStream("d:\\模板导出.pdf");
        fos.write(bos.toByteArray());
        Document doc = new Document();
        PdfCopy pdfCopy = new PdfCopy(doc, fos);
        doc.open();
        PdfPTable table = new PdfPTable(new float[]{1000f});
        table.addCell(new Paragraph(bos.toString()));
        doc.close();
    }

    public static void main(String[] args) {
        try {
            writePdf();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (DocumentException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
