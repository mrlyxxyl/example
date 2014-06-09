package gui;
import java.awt.*;

public class TestPanel2 {
	public static void main(String[] args) {
		new MyFrame3("MyFrameWithPanel", 300, 300, 400, 300);
	}

}

class MyFrame3 extends Frame {
	private static final long serialVersionUID = 1L;
	private Panel p;

	MyFrame3(String s, int x, int y, int w, int h) {
		super(s);
		setLayout(null);
		p = new Panel(null);
		p.setBounds(w / 4, h / 4, w / 2, h / 2);
		p.setBackground(Color.cyan);

		add(p);
		setBounds(x, y, w, h);
		setBackground(Color.BLUE);
		setVisible(true);

	}
}