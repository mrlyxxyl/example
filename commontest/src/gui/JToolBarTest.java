package gui;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class JToolBarTest {

	public static void main(String[] args) {
		JButton button1 = new JButton("�½��ļ�");
		JButton button2 = new JButton("�༭");
		JButton button3 = new JButton("����");
		JButton button4 = new JButton("����");
		

		button1.setToolTipText("�½��ļ�");

		JToolBar bar = new JToolBar();
		bar.add(button1);
		bar.add(button2);
		bar.add(button3);
		bar.add(button4);
		bar.setFloatable(true);

		JFrame frame = new JFrame("��������ʹ��");
		frame.add(bar, BorderLayout.NORTH);
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
