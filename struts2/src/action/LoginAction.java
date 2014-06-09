package action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Date;

public class LoginAction {

    private Date birthday;

    public String execute() {
        ActionContext context = ActionContext.getContext();
        context.getApplication().put("app", "apppppp");
        context.getSession().put("ses", "ssssss");
        context.put("names", Arrays.asList("nanmeiying","yuexin"));
        return "success";
    }

    public String rsa(){
        HttpServletRequest request = ServletActionContext.getRequest();
        ServletContext context = ServletActionContext.getServletContext();
        HttpSession session = request.getSession();
        request.setAttribute("req","req·¶Î§");
        context.setAttribute("app","app·¶Î§");
        session.setAttribute("res","res·¶Î§");
        return "success";
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
