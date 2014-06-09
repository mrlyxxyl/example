package action;

public class TestBreakPoint {

    public static void main(String[] args) {
        int[] arrs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 90};
        lebel1:
        for (int i = 0; i < arrs.length; i++) {
            for (int j =0; j < arrs.length; j++){
                System.out.println(i);
                if (5 == j) {
                    break lebel1;
                }
            }
        }
    }

}
