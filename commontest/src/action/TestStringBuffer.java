package action;

public class TestStringBuffer  {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(10);
        sb.append("jfsa");
        System.out.println(getdd(sb));
    }

    public static StringBuffer clear(StringBuffer sb) {
        return sb.delete(0, sb.length());
    }

    public static <T> T getdd(T t){
        return t;
    }
}
