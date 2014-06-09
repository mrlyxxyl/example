package gui;
import java.awt.*;

public class TestTen {

	public static void main(String[] args) {
		Frame f = new Frame("java Framek");

		f.setLayout(new GridLayout(2, 1));
		f.setLocation(300, 400);
		f.setSize(300, 300);
		f.setBackground(new Color(204, 204, 205));

		Panel p1 = new Panel(new BorderLayout());
		Panel p2 = new Panel(new BorderLayout());

		Panel p11 = new Panel(new GridLayout(2, 1));
		Panel p21 = new Panel(new GridLayout(2, 2));
		p1.add(new Button("Button1"), BorderLayout.WEST);
		p1.add(new Button("Button2"), BorderLayout.EAST);
		p11.add(new Button("Button3"));
		p11.add(new Button("Button4"));
		p1.add(p11, BorderLayout.CENTER);
		p2.add(new Button("Button5"), BorderLayout.WEST);
		p2.add(new Button("Button6"), BorderLayout.EAST);
		for (int i = 1; i <= 4; i++) {
			p21.add(new Button("Button7"));
		}
		p2.add(p21, BorderLayout.CENTER);
		f.add(p11);
		f.add(p2);
		f.setVisible(true);
	}

}
