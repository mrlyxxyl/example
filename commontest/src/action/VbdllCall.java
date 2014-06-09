package action;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class VbdllCall {

    public static String md5CallVbdll(String str) {
        String res;
        try {
            ActiveXComponent pp = new ActiveXComponent("md5.Class1");
            Dispatch myCom = pp.getObject(); //生成一个对象
            Variant result = Dispatch.call(myCom, "MD5", str);
            res = result.toString();
        } catch (Exception e) {
            res = "";
            e.printStackTrace();
        }
        return res;
    }
}