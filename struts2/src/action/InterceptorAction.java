package action;

public class InterceptorAction {

    private String message;

    public String addUI() {
        message = "addUI";
        return "success";
    }

    public String execute() {
        message = "execute";
        return "success";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
