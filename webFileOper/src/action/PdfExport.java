package action;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;


public class PdfExport extends PdfPageEventHelper {
    public static final String BASE_FONT = "c:/windows/fonts/simsun.ttc,1";
    public PdfTemplate tpl;
    public BaseFont bf;

    public static void main(String[] args) {
        Document document = new Document(PageSize.A4, 20, 20, 20, 20);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("f:\\HelloItext.pdf"));
            writer.setPageEvent(new PdfExport());
            BaseFont bfChinese = BaseFont.createFont(BASE_FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            document.open();
            Paragraph title = new Paragraph("�������ݡ�������", new Font(bfChinese, 15));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.close();
        } catch (Exception de) {
            de.printStackTrace();
        }

    }

    public void onOpenDocument(PdfWriter writer, Document document) {
        try {
            tpl = writer.getDirectContent().createTemplate(100, 100);
            bf = BaseFont.createFont(BASE_FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }


    public void onEndPage(PdfWriter writer, Document document) {
        //��ÿҳ������ʱ��ѡ���xҳ����Ϣд��ģ��ָ��λ��
        PdfContentByte cb = writer.getDirectContent();
        cb.saveState();
        String text = "��" + writer.getPageNumber() + "ҳ,��";
        cb.beginText();
        cb.setFontAndSize(bf, 8);
        cb.setTextMatrix(460, 786); //��λ����xҳ,���� �ھ����ҳ�����ʱ����Ҫ������xy������
        cb.showText(text);
        cb.endText();
        cb.addTemplate(tpl, 492, 786); //��λ��yҳ�� �ھ����ҳ�����ʱ����Ҫ������xy������
        cb.saveState();
        cb.stroke();
        cb.restoreState();
        cb.closePath();//sanityCheck();
    }


    public void onCloseDocument(PdfWriter writer, Document document) {
        //�ر�document��ʱ���ȡ��ҳ����������ҳ����ģ��д��֮ǰԤ����λ��
        tpl.beginText();
        tpl.setFontAndSize(bf, 8);
        tpl.showText(Integer.toString(writer.getPageNumber() - 1) + "ҳ");
        tpl.endText();
        tpl.closePath();//sanityCheck();
    }
}
