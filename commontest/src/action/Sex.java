package action;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-5
 * Time: ����11:58
 * To change this template use File | Settings | File Templates.
 */
public enum Sex {
    NAN("��"), NV("Ů");

    private Sex(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
