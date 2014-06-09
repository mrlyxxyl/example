package gui;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TestKeyAction {

	public static void main(String[] args) {
		KeyFrame kfFrame = new KeyFrame();
		kfFrame.launchFrame();

	}

}

class KeyFrame extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void launchFrame() {
		setSize(200,300);
		setLocation(300,300);
		setVisible(true);
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_UP ) {
					System.out.println("okgfgf");
				}
				super.keyPressed(e);
			}

		});
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(-1);
				super.windowClosing(e);
			}
			
		});
		
	}
}