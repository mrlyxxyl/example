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
 * Time: 下午9:01
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
        PdfPTable table = initCmnPdfPTable("a");     // 生成Pdf文件
        PdfPCell cell;
        String dd = "福建凯撒";
        BaseFont bfChinese = BaseFont.createFont(BASE_FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font headFont2 = new Font(bfChinese, 12, Font.NORMAL);// 设置字体大小
        List<String> strs = new ArrayList<String>();
       /* strs.add("交易码：" + StringUtils.pad4ChineseToByteLength(false, dd, 25, " ") + "交易柜员：" + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "交易日期：" + dd);
        strs.add("");
        strs.add("账号：" + StringUtils.pad4ChineseToByteLength(false, dd, 50, " ") + "起息日期：" + dd);
        strs.add("");
        strs.add("户名：" + dd);
        strs.add("");
        strs.add("本金        利率          利息          征税利息        未征税利息");
        strs.add(StringUtils.pad4ChineseToByteLength(false, dd, 10, " ") + "期内 " + StringUtils.pad4ChineseToByteLength(false, dd+"%", 10, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 17, " ") + dd);
        strs.add(StringUtils.pad4ChineseToByteLength(true, "活期 ", 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd + "%", 10, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 17, " ") + dd);
        strs.add(StringUtils.pad4ChineseToByteLength(true, "保值 ", 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd + "%", 10, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 17, " ") + dd);
        strs.add("");
        strs.add("      其他   税率 " + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "利息税 " + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "手续费 " + dd);
        strs.add("");
        strs.add("      货币代码 " + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "实付金额 " + dd);
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
        strs.add("本证实书仅对存款人开户证实，不得作为质押权利凭证");
        strs.add("");


        for (String row : strs) {
            cell = new PdfPCell(new Paragraph(row, headFont2));
            cell.setBorder(0);
            cell.setFixedHeight(18);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
        }


        PdfPTable table2 = initCmnPdfPTable("afdsafs");     // 生成Pdf文件
        PdfPCell cell2;
        String dd2 = "福建凯撒";
        BaseFont bfChinese2 = BaseFont.createFont(BASE_FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font headFont3 = new Font(bfChinese, 12, Font.NORMAL);// 设置字体大小
        List<String> strs2 = new ArrayList<String>();
       /* strs.add("交易码：" + StringUtils.pad4ChineseToByteLength(false, dd, 25, " ") + "交易柜员：" + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "交易日期：" + dd);
        strs.add("");
        strs.add("账号：" + StringUtils.pad4ChineseToByteLength(false, dd, 50, " ") + "起息日期：" + dd);
        strs.add("");
        strs.add("户名：" + dd);
        strs.add("");
        strs.add("本金        利率          利息          征税利息        未征税利息");
        strs.add(StringUtils.pad4ChineseToByteLength(false, dd, 10, " ") + "期内 " + StringUtils.pad4ChineseToByteLength(false, dd+"%", 10, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 17, " ") + dd);
        strs.add(StringUtils.pad4ChineseToByteLength(true, "活期 ", 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd + "%", 10, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 17, " ") + dd);
        strs.add(StringUtils.pad4ChineseToByteLength(true, "保值 ", 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd + "%", 10, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + StringUtils.pad4ChineseToByteLength(false, dd, 17, " ") + dd);
        strs.add("");
        strs.add("      其他   税率 " + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "利息税 " + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "手续费 " + dd);
        strs.add("");
        strs.add("      货币代码 " + StringUtils.pad4ChineseToByteLength(false, dd, 15, " ") + "实付金额 " + dd);
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
        PdfPTable table = new PdfPTable(new float[]{1000f});// 建立一个pdf表格
        table.setSpacingBefore(160f);// 设置表格上面空白宽度
        table.setTotalWidth(1000);// 设置表格的宽度
        table.setLockedWidth(false);// 设置表格的宽度固定
        table.getDefaultCell().setBorder(0);//设置表格默认为无边框
        BaseFont bfChinese = BaseFont.createFont(BASE_FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font headFont1 = new Font(bfChinese, 14, Font.BOLD);// 设置字体大小
        PdfPCell blankCell = new PdfPCell(new Paragraph());
        blankCell.setBorder(0);
        blankCell.setFixedHeight(20);
        table.addCell(blankCell);
        PdfPCell cell = new PdfPCell(new Paragraph(title, headFont1));
        cell.setBorder(0);
        cell.setFixedHeight(15);//单元格高度
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        blankCell.setFixedHeight(5);
        table.addCell(blankCell);
        return table;
    }

    // 单页打印
    public void printPdfTable(PdfPTable table,PdfPTable table2, HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4, 16, 16, 36, 90);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, bos);
        writer.setPageEvent(new PdfPageEventHelper());
        document.open();
        document.add(table);
        document.newPage();//分页用的
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
