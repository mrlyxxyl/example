package gui;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Tabkbedpannel {

	public static void main(String[] args) {
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel panel = new JPanel();
		JButton button = new JButton("���������������");
		panel.add(button);
		
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		
		tabbedPane.addTab("ѡ�һ", panel);
		tabbedPane.addTab("ѡ���", panel2);
		tabbedPane.addTab("ѡ���", panel3);
		
		tabbedPane.setSelectedIndex(1);
		
		JFrame frame = new JFrame("ѡ���ʹ��");
		frame.setBounds(200,300,400,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(tabbedPane);
		frame.setVisible(true);
		
		

	}

}
