package gui;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Tabkbedpannel {

	public static void main(String[] args) {
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel panel = new JPanel();
		JButton button = new JButton("你好吗我是李月新");
		panel.add(button);
		
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		
		tabbedPane.addTab("选项卡一", panel);
		tabbedPane.addTab("选项卡二", panel2);
		tabbedPane.addTab("选项卡三", panel3);
		
		tabbedPane.setSelectedIndex(1);
		
		JFrame frame = new JFrame("选项卡的使用");
		frame.setBounds(200,300,400,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(tabbedPane);
		frame.setVisible(true);
		
		

	}

}
