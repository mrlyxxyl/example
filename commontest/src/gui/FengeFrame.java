package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class FengeFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("分割面板的使用");
		frame.setBounds(200,300,400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JPanel(), new JPanel());//分割方向
		
		splitPane.setOneTouchExpandable(false);//设置分割器
		splitPane.setDividerLocation(8);
		
		frame.add(splitPane);
		frame.setVisible(true);
		
		splitPane.setDividerLocation(0.5);
	}

}
