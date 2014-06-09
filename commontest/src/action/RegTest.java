package action;

public class RegTest {
    public static void main(String[] args) {
        String id = "37020519931227925X";
//        371325198802070911
        String regStr = "\\d{6}((19)|(20))\\d{2}((0\\d)|(1[012]))(([012]\\d)|(3[01]))\\d{3}(\\d|[xX])";
/*        if (id.matches(regStr)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }*/
        String birthday = "1999-02-22";
        String birReg = "((19)|(20))\\d{2}-((0\\d)|(1[012]))-(([012]\\d)|(3[01]))";
        if (birthday.matches(birReg)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
