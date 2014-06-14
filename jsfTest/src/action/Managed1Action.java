package action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class Managed1Action implements Serializable {
    public String getName() {
        return "nanmeiying";
    }
}
