package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame("Graphics的使用");
		frame.setBounds(200, 300, 400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Graphics2Dpanel());
		frame.setVisible(true);

	}

}

class Graphics2Dpanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g) {

		Font font = new Font("隶书", Font.BOLD + Font.ITALIC, 30);

		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setFont(font);
		graphics2d.drawString("李月新", 50, 50);
		graphics2d.setPaint(Color.CYAN);
		graphics2d.drawString("李月新", 100, 250);
		graphics2d.drawLine(10, 20, 100, 40);
		graphics2d.setPaint(Color.red);
		graphics2d.drawString("李月新", 200, 250);
		graphics2d.drawLine(20, 10, 50, 350);

	}

}
