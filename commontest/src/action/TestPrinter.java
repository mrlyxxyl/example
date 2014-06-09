package action;

import javax.print.*;
import javax.print.attribute.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 测试打印机的使用
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
            PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);// 用户可选用的PrintService实例数组。
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService(); // 默认的PrintService
            PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
            if (service != null) {
                DocPrintJob job = service.createPrintJob(); // 创建打印任务
                FileInputStream fis;
                fis = new FileInputStream(filename);
                DocAttributeSet das = new HashDocAttributeSet();
                Doc doc = new SimpleDoc(fis, flavor, das); //定义要打印的文档
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
