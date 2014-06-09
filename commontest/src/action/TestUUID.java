package action;

import java.util.UUID;

public class TestUUID {
    public static void main(String[] args) {
        for (int i = 0; i<10000000;i++){
            String s = ""+i;
            System.out.println(s.hashCode());

        }
    }
}
