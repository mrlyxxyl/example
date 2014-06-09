package gui;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicsT {

	public static void main(String[] args) {
	}

}

class GFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GFrame() {
		setBounds(200, 200, 640, 640);
		setVisible(true);
	}

	// paint是Frame的一个方法，画图时重写该方法就行；
	@Override
	public void paint(Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.blue);
		g.fillOval(50, 50, 30, 30);
		g.setColor(Color.red);
		g.fillRect(80, 80, 40, 40);
		g.setColor(color);
	}
}