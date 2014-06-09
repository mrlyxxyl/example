package action;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-20
 * Time: ����9:01
 * To change this template use File | Settings | File Templates.
 */
public class PdfServlet extends HttpServlet {

    public static final String BASE_FONT = "c:/windows/fonts/simsun.ttc,1";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            print(response);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void print(HttpServletResponse response) throws IOException, DocumentException {
        PdfPTable table = initCmnPdfPTable("a");     // ����Pdf�ļ�
        PdfPCell cell;
        String dd = "��������";
        BaseFont bfChinese = BaseFont.createFont(BASE_FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font headFont2 = new Font(bfChinese, 12, Font.NORMAL);// ���������С
        List<String> strs = new ArrayList<String>();
       /* strs.add("�����룺" + StringUtils.pad4ChineseToByteLength(false, dd, 25, " ") + "���׹�Ա��" + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "�������ڣ�" + dd);
        strs.add("");
        strs.add("�˺ţ�" + StringUtils.pad4ChineseToByteLength(false, dd, 50, " ") + "��Ϣ���ڣ�" + dd);
        strs.add("");
        strs.add("������" + dd);
        strs.add("");
        strs.add("����        ����          ��Ϣ          ��˰��Ϣ        δ��˰��Ϣ");
        strs.add(StringUtils.pad4ChineseToByteLength(false, dd, 10, " ") + "���� " + StringUtils.pad4ChineseToByteLength(false, dd+"%", 10, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 17, " ") + dd);
        strs.add(StringUtils.pad4ChineseToByteLength(true, "���� ", 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd + "%", 10, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 17, " ") + dd);
        strs.add(StringUtils.pad4ChineseToByteLength(true, "��ֵ ", 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd + "%", 10, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 17, " ") + dd);
        strs.add("");
        strs.add("      ����   ˰�� " + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "��Ϣ˰ " + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "������ " + dd);
        strs.add("");
        strs.add("      ���Ҵ��� " + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "ʵ����� " + dd);
*/

        strs.add("       " + StringUtils.pad4ChineseToByteLength(false, dd, 18, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 25, " ") + dd);
        strs.add("");
        strs.add("");
        strs.add("");
        strs.add("                " + StringUtils.pad4ChineseToByteLength(false, dd, 40, " ") + dd);
        strs.add("");
        strs.add("                " + dd);
        strs.add("");
        strs.add("                " + StringUtils.pad4ChineseToByteLength(false, dd, 40, " ") + dd);
        strs.add("            " + dd + " " + dd);
        strs.add("");
        strs.add("       " + StringUtils.pad4ChineseToByteLength(false, dd, 20, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + dd + "%");
        strs.add("");
        strs.add("��֤ʵ����Դ���˿���֤ʵ��������Ϊ��ѺȨ��ƾ֤");
        strs.add("");


        for (String row : strs) {
            cell = new PdfPCell(new Paragraph(row, headFont2));
            cell.setBorder(0);
            cell.setFixedHeight(18);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
        }


        PdfPTable table2 = initCmnPdfPTable("afdsafs");     // ����Pdf�ļ�
        PdfPCell cell2;
        String dd2 = "��������";
        BaseFont bfChinese2 = BaseFont.createFont(BASE_FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font headFont3 = new Font(bfChinese, 12, Font.NORMAL);// ���������С
        List<String> strs2 = new ArrayList<String>();
       /* strs.add("�����룺" + StringUtils.pad4ChineseToByteLength(false, dd, 25, " ") + "���׹�Ա��" + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "�������ڣ�" + dd);
        strs.add("");
        strs.add("�˺ţ�" + StringUtils.pad4ChineseToByteLength(false, dd, 50, " ") + "��Ϣ���ڣ�" + dd);
        strs.add("");
        strs.add("������" + dd);
        strs.add("");
        strs.add("����        ����          ��Ϣ          ��˰��Ϣ        δ��˰��Ϣ");
        strs.add(StringUtils.pad4ChineseToByteLength(false, dd, 10, " ") + "���� " + StringUtils.pad4ChineseToByteLength(false, dd+"%", 10, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 17, " ") + dd);
        strs.add(StringUtils.pad4ChineseToByteLength(true, "���� ", 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd + "%", 10, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 17, " ") + dd);
        strs.add(StringUtils.pad4ChineseToByteLength(true, "��ֵ ", 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd + "%", 10, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 17, " ") + dd);
        strs.add("");
        strs.add("      ����   ˰�� " + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "��Ϣ˰ " + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "������ " + dd);
        strs.add("");
        strs.add("      ���Ҵ��� " + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "ʵ����� " + dd);
*/

        strs2.add("       " + StringUtils.pad4ChineseToByteLength(false, dd, 18, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 25, " ") + dd);
        strs2.add("");
        strs2.add("vdfdsafdsfdsafdsafdsafdsfds");



        for (String row : strs2) {
            cell2 = new PdfPCell(new Paragraph(row, headFont2));
            cell2.setBorder(0);
            cell2.setFixedHeight(18);
            cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            table2.addCell(cell2);
        }
        printPdfTable(table,table2, response);
    }

    public PdfPTable initCmnPdfPTable(String title) throws IOException, DocumentException {
        PdfPTable table = new PdfPTable(new float[]{1000f});// ����һ��pdf���
        table.setSpacingBefore(160f);// ���ñ������հ׿��
        table.setTotalWidth(1000);// ���ñ��Ŀ��
        table.setLockedWidth(false);// ���ñ��Ŀ�ȹ̶�
        table.getDefaultCell().setBorder(0);//���ñ��Ĭ��Ϊ�ޱ߿�
        BaseFont bfChinese = BaseFont.createFont(BASE_FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font headFont1 = new Font(bfChinese, 14, Font.BOLD);// ���������С
        PdfPCell blankCell = new PdfPCell(new Paragraph());
        blankCell.setBorder(0);
        blankCell.setFixedHeight(20);
        table.addCell(blankCell);
        PdfPCell cell = new PdfPCell(new Paragraph(title, headFont1));
        cell.setBorder(0);
        cell.setFixedHeight(15);//��Ԫ��߶�
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// ��������ˮƽ������ʾ
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        blankCell.setFixedHeight(5);
        table.addCell(blankCell);
        return table;
    }

    // ��ҳ��ӡ
    public void printPdfTable(PdfPTable table,PdfPTable table2, HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4, 16, 16, 36, 90);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, bos);
        writer.setPageEvent(new PdfPageEventHelper());
        document.open();
        document.add(table);
        document.newPage();//��ҳ�õ�
        document.add(table2);
        document.close();
        response.reset();
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "inline");
        response.setContentLength(bos.size());
        response.setHeader("Cache-Control", "max-age=30");
        bos.writeTo(out);
        out.flush();
        out.close();
    }
}
