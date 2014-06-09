package action;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

public class ExportDocTest {

    public static void main(String[] args) {
        InputStream is;
        FileOutputStream fos;
        try {
            String destFile = "f:\\test.doc";
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", "nanmeiying");
            map.put("sex", "ÄÐ");
            map.put("idCard", "200010");
            is = ExportDocTest.class.getClassLoader().getResourceAsStream("biyezheng_moban.doc");
            HWPFDocument doc = new HWPFDocument(is);
            Range bodyRange = doc.getRange();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bodyRange.replaceText("${" + entry.getKey() + "}",
                        entry.getValue());
            }
            fos = new FileOutputStream(destFile);
            doc.write(fos);
            fos.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}