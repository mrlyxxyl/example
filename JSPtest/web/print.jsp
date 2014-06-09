<%@ page import="javax.print.*" %>
<%@ page import="javax.print.attribute.DocAttributeSet" %>
<%@ page import="javax.print.attribute.HashDocAttributeSet" %>
<%@ page import="javax.print.attribute.HashPrintRequestAttributeSet" %>
<%@ page import="javax.print.attribute.PrintRequestAttributeSet" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String filename = "f:\\test.pdf";
    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
    DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
    PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);// 用户可选用的PrintService实例数组。
    int i = 0;
    for (PrintService ps : printService) {
        System.out.println(ps.getName());
        i++;
    }
    PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService(); // 默认的PrintService
    PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pras);
    if (service != null) {
        DocPrintJob job = service.createPrintJob(); // 创建打印任务
        FileInputStream fis;
        fis = new FileInputStream(filename);
        DocAttributeSet das = new HashDocAttributeSet();
        /** 定义要打印的文档*/
        Doc doc = new SimpleDoc(fis, flavor, das);
        job.print(doc, pras);
        Thread.sleep(10000);
        fis.close();
    }
    System.exit(0);
%>