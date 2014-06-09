public class JNITest {
    static{
        System.loadLibrary("PrntInterface"); //注意：不写扩展名，名字要与dll的文件名一致
    }


    public native   long PrntInv(String strPrntData, long pRet);

    public static void main(String[] args) {
        JNITest test=new JNITest();
        test.PrntInv("",0);
    }

}
