package action;

public class TestNull {
    public static void main(String[] args) {
        String str = null;
        if (str == null || str.trim().equals("")) {
            System.out.println("null");
        } else {
            System.out.println("not null");
        }
    }

}
