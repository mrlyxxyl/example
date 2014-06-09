import java.util.UUID;

public class TestUUID {
    public static void main(String[] args) {
        String str = UUID.randomUUID().toString();
        System.out.println(str.length());
    }
}
