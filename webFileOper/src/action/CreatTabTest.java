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
 * Time: ����1:13
 * To change this template use File | Settings | File Templates.
 */
public class CreatTabTest {
    public static final String BASE_FONT = "c:/windows/fonts/simsun.ttc,1";

    public static void writePdf() throws IOException, DocumentException {

        String fileName = "d:\\����ģ��.pdf"; //
        PdfReader reader = new PdfReader(fileName);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfStamper ps = new PdfStamper(reader, bos);
        /**
         * ʹ���������� ��������� AcroFields���ֵ�Ĳ���Ҫ�ڳ������������壬��ģ���ļ�����������Ϊ�������������
         */
/*        BaseFont bf = BaseFont.createFont(BASE_FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(bf, 12, Font.NORMAL);*/
        AcroFields s = ps.getAcroFields();
        s.setField("jid", "010");
        s.setField("bid", "60");
        s.setField("id", "9010600");
        s.setField("name", "����");
        s.setField("date", "20140317");
        s.setField("pl", "0005");
        ps.setFormFlattening(true);
        ps.close();
        FileOutputStream fos = new FileOutputStream("d:\\ģ�嵼��.pdf");
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
