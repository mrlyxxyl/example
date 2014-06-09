package gui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldtest {
	public static String string = null;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(100, 50, 500, 500);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 300, 300);
		panel.setBackground(Color.pink);
		frame.add(panel);

		JButton button = new JButton("提交");

		final JTextField jtf = new JTextField(20);
		panel.add(jtf);
		panel.add(button);
			button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jtf) {
					jtf.requestFocus();
				}
				string = jtf.getText().trim();
				jtf.setText("");
				JOptionPane.showMessageDialog(null, "输入内容为：" + string,"信息提示",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});

	}

}
