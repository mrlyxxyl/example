import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-10-26
 * Time: 下午5:17
 * To change this template use File | Settings | File Templates.
 */
public class TestDeleteFoders {
    /*想要删除文件夹，则文件夹内部不得有文件*/
    public static void main(String[] args) {
        File file = new File("g:\\test");
        file.delete();
    }
}
