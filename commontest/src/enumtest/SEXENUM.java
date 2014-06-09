package enumtest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-18
 * Time: ÏÂÎç12:36
 * To change this template use File | Settings | File Templates.
 */
public enum SEXENUM {
    NAN("ÄÐ"), NV("Å®");
    private String value;

    private SEXENUM(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public static String dd(String te) {
        if (te.equals("01"))
            return NAN.getValue();
        if (te.equals("01"))
            return NV.getValue();
        return "";
    }
}
