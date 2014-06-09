import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class SimpleService {

    public static String getInfo() {
        ActiveXComponent app = new ActiveXComponent("myProj.Class1");
        Dispatch mycom = app.getObject();
        if (mycom != null) {
            Variant result = Dispatch.callN(mycom, "GetCPUid", new String[]{""});
            return result.toString();
        }
        return "";
    }
}