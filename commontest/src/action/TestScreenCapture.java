package action;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class TestScreenCapture {
    public static void main(String[] args) {
        try {   //获取屏幕大小
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();   //截图
            BufferedImage bim = new Robot().createScreenCapture(new Rectangle(0, 0, dim.width, dim.height));
            ImageIO.write(bim, "jpg", new File("E:\\test.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}