package action;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Printing {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            String filename = "f:\\test.pdf";
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);// �û���ѡ�õ�PrintServiceʵ�����顣
            int i = 0;
            for (PrintService ps : printService) {
                System.out.println(ps.getName());
                i++;
            }
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService(); // Ĭ�ϵ�PrintService
            PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
            if (service != null) {
                DocPrintJob job = service.createPrintJob(); // ������ӡ����
                FileInputStream fis;
                fis = new FileInputStream(filename);
                DocAttributeSet das = new HashDocAttributeSet();
                /** ����Ҫ��ӡ���ĵ�*/
                Doc doc = new SimpleDoc(fis, flavor, das);
                job.print(doc, pras);
                Thread.sleep(10000);
                fis.close();
            }
            System.exit(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (PrintException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}