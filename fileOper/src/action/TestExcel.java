package action;

import bean.People;
import net.sf.jxls.transformer.XLSTransformer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestExcel {
    public static void main(String[] args) {

        String srcFilePath = TestExcel.class.getClassLoader().getResource("testExcel.xls").getPath();
        String destFilePath = "f:/test.xls";
        XLSTransformer transformer = new XLSTransformer();
        People people = new People("111", "nanmeiying",new Date());
        Map<String, Object> beanParams = new HashMap<String, Object>();
        beanParams.put("people", people);
        try {
            transformer.transformXLS(srcFilePath, beanParams, destFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
