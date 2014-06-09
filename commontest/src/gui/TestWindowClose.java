package gui;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindowClose {

	public static void main(String[] args) {
	}
}

class WindowFrame extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WindowFrame(String string) {
		super(string);
		setBounds(300, 300, 400, 300);
		setBackground(Color.blue);
		setVisible(true);
		//匿名类不需要在重写或是实现某个接口
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(-1);
			}
		});
	}
}
