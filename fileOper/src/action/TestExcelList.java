package action;

import bean.Score;
import net.sf.jxls.transformer.XLSTransformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestExcelList {
    public static void main(String[] args) {

        String srcFilePath = TestExcelList.class.getClassLoader().getResource("testExcelList.xls").getPath();
        String destFilePath = "f:/testlist.xls";
        XLSTransformer transformer = new XLSTransformer();
        Map<String, Object> beanParams = new HashMap<String, Object>();
        List<Score> list = new ArrayList<Score>();
        list.add(new Score(1, 1, 1, 1));
        list.add(new Score(2, 2, 2, 2));
        list.add(new Score(3, 3, 3, 3));
        list.add(new Score(4, 4, 4, 4));
        beanParams.put("list", list);
        try {
            transformer.transformXLS(srcFilePath, beanParams, destFilePath);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
