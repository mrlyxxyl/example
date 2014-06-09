package gui;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageTest {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Í¼ÏñµÄ¼ÓÔØ");
		frame.setBounds(300, 200, 450, 400);
		JPanel panel = new BoxPanel();
		panel.setLocation((frame.getWidth() - panel.getWidth()) / 2, (frame.getHeight() - 28 - panel.getHeight()) / 2);

		frame.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}

class BoxPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BoxPanel() {
		this.setSize(10 * 32, 10 * 32);
	}

	@Override
	public void paintComponent(Graphics g) {
		Image image = null;

		try {
			image = ImageIO.read(this.getClass().getResource("/gameOver.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				g.drawImage(image, i * 32, j * 32, this);
			}
		}
	}

}
