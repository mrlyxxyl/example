package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class FengeFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("�ָ�����ʹ��");
		frame.setBounds(200,300,400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JPanel(), new JPanel());//�ָ��
		
		splitPane.setOneTouchExpandable(false);//���÷ָ���
		splitPane.setDividerLocation(8);
		
		frame.add(splitPane);
		frame.setVisible(true);
		
		splitPane.setDividerLocation(0.5);
	}

}
