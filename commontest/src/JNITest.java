public class JNITest {
    static{
        System.loadLibrary("PrntInterface"); //ע�⣺��д��չ��������Ҫ��dll���ļ���һ��
    }


    public native   long PrntInv(String strPrntData, long pRet);

    public static void main(String[] args) {
        JNITest test=new JNITest();
        test.PrntInv("",0);
    }

}
