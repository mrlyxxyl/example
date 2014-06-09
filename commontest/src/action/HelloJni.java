package action;

public class HelloJni {
    public native void displayHelloJni();

    static {
        System.loadLibrary("helloJni");
    }

    public static void main(String[] args) {
        new HelloJni().displayHelloJni();
    }
}
