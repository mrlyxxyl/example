package action;

public class HelloWordAction {
    private String username;

    public String excute() {
        return "success";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
