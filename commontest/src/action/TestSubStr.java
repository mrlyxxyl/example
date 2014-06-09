package action;

public class TestSubStr {
    public static void main(String[] args) {
        String tmp = "Content-Disposition: form-data; name=\"filename\"; filename=\"lock.png\"";
        tmp = tmp.substring(tmp.indexOf("filename=") + 10,tmp.length()-1);
        System.out.println(tmp);
    }
}
