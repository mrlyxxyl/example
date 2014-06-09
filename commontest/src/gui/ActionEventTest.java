package gui;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ActionEventTest {

	public static void main(String[] args) {
		final Frame frame = new Frame("TestActionEvent");
		Button button = new Button("Pressed me");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
				
			}
		});
		
		
		frame.add(button);
		frame.pack();
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				frame.setVisible(false);
				System.exit(-1);
			}
			
		});
	}

}



/**

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Test {

	public static void main(String[] args) {
		JFrame frame = new JFrame("监听器测试");
		frame.setBounds(100,100,200,200);
		frame.setVisible(true);
		
		JButton button = new JButton("按下我");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("你好");
			}
		});
		
		frame.add(button);
		
		

	}

}


*/