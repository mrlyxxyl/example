package action;

import javax.print.*;
import javax.print.attribute.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ���Դ�ӡ����ʹ��
 */
public class TestPrinter {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            String filename = "f:\\testprnt.xml";
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);// �û���ѡ�õ�PrintServiceʵ�����顣
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService(); // Ĭ�ϵ�PrintService
            PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
            if (service != null) {
                DocPrintJob job = service.createPrintJob(); // ������ӡ����
                FileInputStream fis;
                fis = new FileInputStream(filename);
                DocAttributeSet das = new HashDocAttributeSet();
                Doc doc = new SimpleDoc(fis, flavor, das); //����Ҫ��ӡ���ĵ�
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
