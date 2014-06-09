public class ShuiKongJNI {

    static {
        System.loadLibrary("shuikong");
    }

    public native void myPrnt();

    public native int intFun();

    public native int intFunWitharg(int a);

    public static void main(String[] args) {
        ShuiKongJNI shuiKongJNI = new ShuiKongJNI();
        shuiKongJNI.myPrnt();
        System.out.println(shuiKongJNI.intFun());
        System.out.println(shuiKongJNI.intFunWitharg(12));
    }
}
