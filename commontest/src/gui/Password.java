package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class Password {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 400, 400);

		final JPasswordField passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				char[] c = null;

				c = passwordField.getPassword();
				for (char a : c) {
					System.out.print(a + " ");
				}
				passwordField.setText("");
			}
		});
		passwordField.setEchoChar('*');
		passwordField.setBounds(10, 10, 126, 26);

		frame.add(passwordField);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

}
