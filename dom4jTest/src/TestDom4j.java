import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

public class TestDom4j {

    /**
     * ��ȡxml�ַ���
     *
     * @return
     * @throws IOException
     */
    public static String getXMLStr() throws IOException {
        Document doc = DocumentHelper.createDocument();
        String xmlStr;
        doc.setXMLEncoding("UTF-8");
        Element root = doc.addElement("InvInfo");
        Element verElem;
        Element invTypeElem;
        Element payClientElem;
        Element fadeInvElem;
        Element itemElem;
        Element tradeDataInfoElem;
        XMLWriter xw;
        StringWriter sw = new StringWriter();
        OutputFormat opf;

        verElem = root.addElement("Version");
        verElem.addText("1.00000");

        invTypeElem = root.addElement("InvType");
        invTypeElem.addText("1");

        payClientElem = root.addElement("PayClient");
        payClientElem.addAttribute("Name", "���Ը��λ").addAttribute("ConUser", "gdma").addAttribute("CardNo", "26878833").addAttribute("Tel", "8886533").addAttribute("TaxNo", "123456").addAttribute("ProxyNo", "sn1733");

        fadeInvElem = root.addElement("fadeInv");
        fadeInvElem.addAttribute("InvCode", "10000000010000000002").addAttribute("InvNo", "55555015");

        itemElem = root.addElement("Item");
        itemElem.addAttribute("name", "������").addAttribute("month", "20070811").addAttribute("num", "29935").addAttribute("price", "2.8").addAttribute("cash", "83818").addAttribute("taxItem", "1").addAttribute("exattrib1", "").addAttribute("exattrib2", "").addAttribute("exattrib3", "").addAttribute("exattrib4", "");

        tradeDataInfoElem = root.addElement("TradeDataInfo");
        tradeDataInfoElem.addAttribute("name", "BUS_REMARK").addAttribute("data", "Hello ����ˮ���Ǳ�ע");

        opf = OutputFormat.createPrettyPrint();
        opf.setEncoding("UTF-8");
        xw = new XMLWriter(sw);
        xw.write(doc);
        xw.close();
        xmlStr = sw.toString();
        sw.close();
        return xmlStr;
    }

    /**
     * ����xml�ַ���
     *
     * @param xml
     */
    public static void readStringXml(String xml) {
        Document doc;
        try {
            doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            Iterator iter = rootElt.elementIterator("InvInfo");
            while (iter.hasNext()) {
                Element recordEle = (Element) iter.next();
                System.out.println(recordEle.attributeValue("TaxCode"));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String xmlStr = "<ReturnInfo><InvInfo InvCode=\"\" InvNo=\"00000001\" Date=\"\" Opter=\"000\" MacCode=\"\" TaxCode=\"00000000000000000000\"/></ReturnInfo>";

        readStringXml(xmlStr);

    }
}