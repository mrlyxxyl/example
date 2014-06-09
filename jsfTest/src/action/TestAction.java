package action;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.yuexin.bean.Invoice;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class TestAction implements Serializable {
    public static final String BASE_FONT = "c:/windows/fonts/simsun.ttc,1";

    private UploadedFile file;
    private List<Invoice> invoiceList = new ArrayList<Invoice>();
    private List<Invoice> selectedInvoices = new ArrayList<Invoice>();

    private boolean flag = true;

       private String value2 = "true";
       private String value1;


    public void vc(){
        System.out.println("jflksjflkds");
    }
    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public void addMessagess(){
        FacesMessage msg = new FacesMessage(value2, value2);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    /**
     * 上传文件
     *
     * @throws IOException
     */
    public void uploadFile() throws IOException {
        if (file != null) {
            try {
                InputStream is = file.getInputstream();
                POIFSFileSystem fs = new POIFSFileSystem(is);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                int rowLen = sheet.getLastRowNum();
                HSSFCell cell;
                String tmp = "";
                Invoice invoiceTmp;
                for (int i = 1; i <= rowLen; i++) {
                    invoiceTmp = new Invoice();
                    int cellNum = sheet.getRow(i).getLastCellNum();
                    for (int j = 0; j < cellNum; j++) {
                        cell = sheet.getRow(i).getCell(j);
                        if (cell != null) {
                            if (cell.getCellType() == 1) {
                                tmp = cell.getStringCellValue().trim();
                            } else if (cell.getCellType() == 0) {
                                tmp = NumberFormat.getNumberInstance().format(cell.getNumericCellValue()).replaceAll(",", "");
                            }
                        } else break;
                        switch (j) {
                            case 0:
                                invoiceTmp.setId(tmp);
                                break;
                            case 1:
                                invoiceTmp.setPayerName(tmp);
                                break;
                            case 2:
                                invoiceTmp.setVocPrice(tmp);
                                break;
                            case 3:
                                invoiceTmp.setVocType(tmp);
                                break;
                            case 4:
                                invoiceTmp.setExitVocCode(tmp);
                                break;
                            case 5:
                                invoiceTmp.setExitVocNum(tmp);
                                break;
                            case 6:
                                invoiceTmp.setVoiNum(tmp);
                                break;
                            case 7:
                                invoiceTmp.setVocState(tmp);
                                break;
                            case 8:
                                invoiceTmp.setTradInf1(tmp);
                                break;
                            case 9:
                                invoiceTmp.setTradInf2(tmp);
                                break;
                            case 10:
                                invoiceTmp.setTradInf3(tmp);
                                break;
                            case 11:
                                invoiceTmp.setTradInf4(tmp);
                                break;
                            case 12:
                                invoiceTmp.setTradInf5(tmp);
                                break;
                            case 13:
                                invoiceTmp.setTradInf6(tmp);
                                break;
                            case 14:
                                invoiceTmp.setTradInf7(tmp);
                                break;
                            case 15:
                                invoiceTmp.setTradInf8(tmp);
                                break;
                            default:
                                break;
                        }
                    }
                    invoiceList.add(invoiceTmp);
                }
                addMessage("导入成功");
            } catch (IOException e) {
                addMessage("导入失败");
            }
        }
    }

    /**
     * 批量打印
     */
    public void batPrint() {
        try {
            List<PdfPTable> tables = getPDFTables();
            if (tables == null) {
                return;
            }
            printPdfTable(tables);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到所有封装的PDFtable
     */
    public List<PdfPTable> getPDFTables() throws IOException, DocumentException {
        if (selectedInvoices.size() == 0) {
            addMessage("请选择要打印的发票!");
            return null;
        }
        List<PdfPTable> pdfPTables = new ArrayList<PdfPTable>();
        PdfPTable table;
        PdfPCell cell;
        BaseFont bfChinese;
        Font headFont2;
        for (Invoice invoice : selectedInvoices) {
            table = initCmnPdfPTable("invoice info");
            bfChinese = BaseFont.createFont(BASE_FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            headFont2 = new Font(bfChinese, 12, Font.NORMAL);// 设置字体大小
            cell = new PdfPCell(new Paragraph(invoice.getId(), headFont2));
            cell.setBorder(0);
            cell.setFixedHeight(18);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph(invoice.getPayerName(), headFont2));
            cell.setBorder(0);
            cell.setFixedHeight(18);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
            pdfPTables.add(table);
        }
        return pdfPTables;
    }

    /**
     * 初始化PDFTable
     *
     * @param title
     * @return
     * @throws IOException
     * @throws DocumentException
     */
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


    /**
     * 打印PDF文件
     *
     * @param tables
     * @throws DocumentException
     * @throws IOException
     */
    public void printPdfTable(List<PdfPTable> tables) throws DocumentException, IOException {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
        Document document = new Document(PageSize.A4, 16, 16, 36, 90);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, bos);
        writer.setPageEvent(new PdfPageEventHelper());
        document.open();
        for (int i = 0; i < tables.size(); i++) {
            document.add(tables.get(i));
            if (i < tables.size() - 1) {
                document.newPage();//分页
            }
        }
        writer.addJavaScript("this.print({bUI: false,bSilent: true,bShrinkToFit: false});" + "\r\nthis.closeDoc();");
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
        ctx.responseComplete();
    }

    public void addMessage(String msgStr) {
        FacesMessage msg = new FacesMessage(msgStr, msgStr);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public List<Invoice> getSelectedInvoices() {
        return selectedInvoices;
    }

    public void setSelectedInvoices(List<Invoice> selectedInvoices) {
        this.selectedInvoices = selectedInvoices;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

}

