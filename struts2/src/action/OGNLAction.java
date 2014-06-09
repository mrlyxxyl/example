package action;

import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OGNLAction {

    private String message;
    private Date birthday;
    private List<String> list;

    public String execute() {
        ActionContext.getContext().put("req", "reqMessage");
        ActionContext.getContext().getSession().put("ses", "sessionMessage");
        ActionContext.getContext().getApplication().put("app", "appMessage");
        birthday = new Date();
        message = "message";

        list = new ArrayList<String>();
        list.add("first");
        list.add("second");
        list.add("third");
        return "success";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
