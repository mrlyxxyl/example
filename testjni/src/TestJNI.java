public class TestJNI {
    public static void main(String[] args) {
        ShuiKongJNI shuiKongJNI = new ShuiKongJNI();
        shuiKongJNI.myPrnt();
        System.out.println(shuiKongJNI.intFun());
        System.out.println(shuiKongJNI.intFunWitharg(12));
    }
}
