package gui;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class NeibuFrame {

	public static void main(String[] args) {
		JDesktopPane desktopPane = new JDesktopPane();

		JInternalFrame internalFrame = new JInternalFrame("�ڲ����1", true, true, true, true);

		internalFrame.setBounds(10, 10, 200, 200);
		internalFrame.setVisible(true);
		desktopPane.add(internalFrame);

		JInternalFrame internalFrame2 = new JInternalFrame("�ڲ����2", true, true, true, true);

		internalFrame2.setBounds(150, 20, 200, 200);
		internalFrame2.setVisible(true);
		desktopPane.add(internalFrame2);

		JFrame frame = new JFrame("�ڲ�frame��ʹ��");
		frame.setBounds(200, 300, 800, 800);
		frame.add(desktopPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
