package gui;
import java.awt.*;

public class TestGrid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("Frme");
		
		Button b1 = new Button("bq");
		Button b2 = new Button("Bd");
		Button b3 = new Button("b3");
		Button b4 = new Button("b4");
		Button b5 = new Button("b5");
		Button b6 = new Button("b6");
		
		
		f.setLayout(new GridLayout(3,2));
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.pack();
		f.setVisible(true);

	}

}
