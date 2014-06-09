package gui;
import java.awt.Color;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class JScrollPaneTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("nihao");
		frame.setBounds(100, 100, 300, 300);

		JScrollPane panel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.setBounds(0, 0, 300, 300);
	panel.setLayout(null);
		TextArea textArea = new TextArea();
		textArea.setBackground(Color.blue);
		textArea.setBounds(0, 0, 300, 300);
		
		textArea.setText("dddddddddddddddfhj和肺结核的健康和附近的恢复健康的合法的身份的事发生发的撒范德萨范德萨发的说法都是法士大夫似的发多少范德萨发的说法都是");
	panel.add(textArea);	frame.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

	}

}
