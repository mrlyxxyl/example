package gui;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class JToolBarTest {

	public static void main(String[] args) {
		JButton button1 = new JButton("新建文件");
		JButton button2 = new JButton("编辑");
		JButton button3 = new JButton("帮助");
		JButton button4 = new JButton("关于");
		

		button1.setToolTipText("新建文件");

		JToolBar bar = new JToolBar();
		bar.add(button1);
		bar.add(button2);
		bar.add(button3);
		bar.add(button4);
		bar.setFloatable(true);

		JFrame frame = new JFrame("工具条的使用");
		frame.add(bar, BorderLayout.NORTH);
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
