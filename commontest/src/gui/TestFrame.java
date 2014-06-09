package gui;
import java.awt.*;

public class TestFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}

class MyFrame extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int id = 0;
	MyFrame(int x, int y, int w, int h, Color color){
		super("MyFrame " + (++id));
		setBackground(color);
		setLayout(null);
		setBounds(x,y,w,h);
		setVisible(true);
		
	}
}
