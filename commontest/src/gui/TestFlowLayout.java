package gui;
import java.awt.*;

public class TestFlowLayout {

	public static void main(String[] args) {
		Frame f = new Frame("Border Layout");

		Button bn = new Button("BN");
		Button bs = new Button("BS");
		Button bw = new Button("BW");
		Button be = new Button("BE");
		Button bc = new Button("BC");

		f.add(bn, BorderLayout.NORTH);
		f.add(bs, BorderLayout.SOUTH);
		f.add(bw, BorderLayout.WEST);
		f.add(be, BorderLayout.CENTER);
		f.add(bc, BorderLayout.EAST);

		f.setSize(200, 200);
		f.setVisible(true);
	}

}
