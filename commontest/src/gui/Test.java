package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Test {

	public static void main(String[] args) {
		JFrame frame = new JFrame("����������");
		frame.setBounds(100,100,200,200);
		frame.setVisible(true);
		
		JButton button = new JButton("������");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("���");
			}
		});
		
		frame.add(button);
		
		

	}

}
