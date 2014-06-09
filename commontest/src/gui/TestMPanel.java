package gui;
import java.awt.*;

public class TestMPanel {
	public static void main(String[] args) {
		new MyFrame2("MyFrameWithPanel", 300, 300, 400, 300);
	}
}

class MyFrame2 extends Frame {

	private static final long serialVersionUID = 1L;
	private Panel p1, p2, p3, p4;

	MyFrame2(String s, int x, int y, int w, int h) {
		super(s);
		setLayout(null);
		p1 = new Panel(null);
		p2 = new Panel(null);
		p3 = new Panel(null);
		p4 = new Panel(null);
		p1.setBounds(0, 0, w / 2, h / 2);
		p2.setBounds(0, h / 2, w / 2, h / 2);
		p3.setBounds(w / 2, 0, w / 2, h / 2);
		p4.setBounds(w / 2, h / 2, w / 2, h / 2);
		p1.setBackground(Color.cyan);
		p2.setBackground(Color.green);
		p3.setBackground(Color.LIGHT_GRAY);
		p4.setBackground(Color.blue);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		setBounds(x, y, w, h);
		setVisible(true);

	}
}