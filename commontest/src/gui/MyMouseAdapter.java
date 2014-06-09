package gui;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyMouseAdapter {
	public static void main(String[] args) {
		new MyFrameAdapter("drawing...");
	}
}

class MyFrameAdapter extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Point> points = null;//´´½¨ÈÝÆ÷

	public MyFrameAdapter(String s) {
		super(s);
		points = new ArrayList<Point>();
		setLayout(null);
		setBounds(300, 300, 400, 300);
		setBackground(new Color(204, 204, 255));
		setVisible(true);
		addMouseListener(new Monitor1());
	}

	@Override
	public void paint(Graphics g) {
		java.util.Iterator<Point> i = points.iterator();
		while (i.hasNext()) {
			Point p = (Point) i.next();
			g.setColor(Color.blue);
			g.fillOval(p.x, p.y, 10, 10);
		}
	}

	public void addPoint(Point p) {
		points.add(p);
	}

}

class Monitor1 extends MouseAdapter {

	@Override
	public void mousePressed(MouseEvent e) {
		MyFrameAdapter f = (MyFrameAdapter) e.getSource();
		f.addPoint(new Point(e.getX(), e.getY()));
		f.repaint();
		super.mousePressed(e);
	}

}
