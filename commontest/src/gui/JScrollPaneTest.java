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
		
		textArea.setText("dddddddddddddddfhj�ͷν�˵Ľ����͸����Ļָ������ĺϷ�����ݵ��·�������������������������˵�����Ƿ�ʿ����Ƶķ����ٷ���������˵������");
	panel.add(textArea);	frame.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

	}

}
