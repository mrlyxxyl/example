package flappybird.data;

import java.awt.*;

import flappybird.Parameter;

public class Ground implements Parameter{
	private static final int X = 0;
	private static final int Y = SCREEN_HEIGHT-GROUND_HEIGHT;
	
	public void drawGround(Graphics g ) {
		Color c = g.getColor();
		g.setColor(new Color(128,64,0));     //ÍÁ»ÆÉ«
		g.fillRect(X, Y, GROUND_WIDTH, GROUND_HEIGHT);
		g.setColor(c);
	}
	
	public Rectangle getRec() {
		return new Rectangle(X, Y, GROUND_WIDTH, GROUND_HEIGHT);
	}
	
}
