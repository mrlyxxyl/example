public class HelloJni {
    public native void displayHelloJni();

    public native int getDynamicIntDataNoParam();

    public native int getDynamicIntData(int i);

    public native String getDynamicStringData(String arg);

    public native int[] getDynamicArrayData(int[] args);


    static {
//        System.loadLibrary("helloJni");
        System.loadLibrary("PrntInterface");
    }

    public static void main(String[] args) {

       HelloJni helloJni = new HelloJni();
        helloJni.displayHelloJni();

/*
        int[] arr = new int[]{1,5,9,3,8,1,2,8,23,43};
        int[] arr2 = helloJni.getDynamicArrayData(arr);
        for (int i :arr2){
            System.out.print(i + " ");
        }*/

        /*helloJni.displayHelloJni();

        int dint = helloJni.getDynamicIntDataNoParam();

        int did = helloJni.getDynamicIntData(5);

        String ss = helloJni.getDynamicStringData("hello world!");


        System.out.println("dint: " + dint);
        System.out.println("did: " + did);
        System.out.println("ss: " + ss);*/

    }
}