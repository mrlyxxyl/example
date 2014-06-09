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
                System.out.println("���Ӵ�ӡ���ɹ�! ");
                PrintWriter pw = new PrintWriter(fw);
                pw.print("\r\n");
                pw.print("������Ҫ��ӡ�Ķ�����");
                pw.close();
                fw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printSet1(HSSFSheet sheet) throws Exception {
        // print set
        sheet.setHorizontallyCenter(true);// ����ˮƽ����
        // SheetSettings set = new SheetSettings();
        // set.setOrientation(PageOrientation.PORTRAIT);
        sheet.setMargin(HSSFSheet.TopMargin, (double) 1);// ������߾� 1=2.5cm
//   sheet.setMargin(HSSFSheet.LeftMargin, (double) 1);
        sheet.setMargin(HSSFSheet.LeftMargin, (double) 1);
        sheet.setMargin(HSSFSheet.BottomMargin, (double) 1);
        sheet.setMargin(HSSFSheet.RightMargin, (double) 1);
        HSSFPrintSetup ps = sheet.getPrintSetup();
        ps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);
        // yanghl 2010-06-23 ���������ӡ.
//   ps.setLandscape(true);// ���ú����ӡ
        ps.setLandscape(false);// ���������ӡ
        // ps.setLandscape(false);

        // ps.setScale((short) 85);
        ps.setScale((short) 79); // ���ô�ӡ���ű���
        ps.setHeaderMargin((double) 0.5);// ����ҳü��ӡ��Χ
        ps.setFooterMargin((double) 0.5);// ����ҳ�Ŵ�ӡ��Χ
    }

}
