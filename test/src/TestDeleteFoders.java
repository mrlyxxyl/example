import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-10-26
 * Time: ����5:17
 * To change this template use File | Settings | File Templates.
 */
public class TestDeleteFoders {
    /*��Ҫɾ���ļ��У����ļ����ڲ��������ļ�*/
    public static void main(String[] args) {
        File file = new File("g:\\test");
        file.delete();
    }
}
