package action;

import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.io.FileWriter;
import java.io.PrintWriter;

public class TestPrint {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("f:/test.pdf");
            if (fw != null) {
                System.out.println("连接打印机成功! ");
                PrintWriter pw = new PrintWriter(fw);
                pw.print("\r\n");
                pw.print("这是我要打印的东西。");
                pw.close();
                fw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printSet1(HSSFSheet sheet) throws Exception {
        // print set
        sheet.setHorizontallyCenter(true);// 设置水平居中
        // SheetSettings set = new SheetSettings();
        // set.setOrientation(PageOrientation.PORTRAIT);
        sheet.setMargin(HSSFSheet.TopMargin, (double) 1);// 设置左边距 1=2.5cm
//   sheet.setMargin(HSSFSheet.LeftMargin, (double) 1);
        sheet.setMargin(HSSFSheet.LeftMargin, (double) 1);
        sheet.setMargin(HSSFSheet.BottomMargin, (double) 1);
        sheet.setMargin(HSSFSheet.RightMargin, (double) 1);
        HSSFPrintSetup ps = sheet.getPrintSetup();
        ps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);
        // yanghl 2010-06-23 设置纵向打印.
//   ps.setLandscape(true);// 设置横向打印
        ps.setLandscape(false);// 设置纵向打印
        // ps.setLandscape(false);

        // ps.setScale((short) 85);
        ps.setScale((short) 79); // 设置打印缩放比例
        ps.setHeaderMargin((double) 0.5);// 设置页眉打印范围
        ps.setFooterMargin((double) 0.5);// 设置页脚打印范围
    }

}
