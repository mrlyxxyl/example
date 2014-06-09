package gui;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFieldTest {

	public static void main(String[] args) {
	}

}

class TextFrame extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TextField num1, num2, num3;

	public TextFrame() {
		num1 = new TextField(10);
		num2 = new TextField(10);
		num3 = new TextField(15);
		Label label = new Label("+");
		Button btn = new Button("=");
		btn.addActionListener(new TFActionListener(this));
		setLayout(new FlowLayout());
		

		add(num1);
		add(label);
		add(num2);
		add(btn);
		add(num3);

		pack();
		setVisible(true);

	}
}

class TFActionListener implements ActionListener {

	//持有对方引用
	TextFrame tfFrame = null;
	public TFActionListener(TextFrame tf) {
		this.tfFrame = tf;
	}

	
	public void actionPerformed(ActionEvent e) {
		int n1 = Integer.parseInt(tfFrame.num1.getText());
		int n2 = Integer.parseInt(tfFrame.num2.getText());
		tfFrame.num3.setText("" + (n1 * n2));

	}

}