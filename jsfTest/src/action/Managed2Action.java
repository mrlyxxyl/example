package action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class Managed2Action implements Serializable {
    @ManagedProperty(value = "#{managed1Action}")
    private Managed1Action managed1Action;

    private String name;


    public void save() {
        name = managed1Action.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Managed1Action getManaged1Action() {
        return managed1Action;
    }

    public void setManaged1Action(Managed1Action managed1Action) {
        this.managed1Action = managed1Action;
    }
}
