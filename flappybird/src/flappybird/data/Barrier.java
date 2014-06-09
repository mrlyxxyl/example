package flappybird.data;

import java.applet.*;
import java.awt.*;
import java.util.*;

import flappybird.Parameter;

public class Barrier implements Parameter {
    private static AudioClip getPoint = Applet.newAudioClip(Barrier.class.getClassLoader().getResource("flappybird/music/getpoint.wav"));

    private static final int SPEED = 1;

    private static int playerScore = 0;

    private int x, ty, uy;
    private int topHeight;
    private int underHeight;

    private boolean init = false;

    public Barrier(int x, int ty) {
        this.x = x;
        this.ty = ty;
    }

    private void init() {
        Random r = new Random();
        int intRan = r.nextInt(5) + 1;
        topHeight = BARRIER_HEIGHT * intRan;
        underHeight = BARRIER_HEIGHT * (ROWS_COUNT - 3 - intRan);
        uy = ty + topHeight + 2 * BARRIER_HEIGHT;
    }

    public void drawBarrier(Graphics g) {
        if (!init) {
            init();
            init = true;
        }
        Color c = g.getColor();
        g.setColor(new Color(0, 128, 0)); // ÉîÂÌ
        g.fillRect(x, ty, BARRIER_WIDTH, topHeight);
        g.fillRect(x, uy, BARRIER_WIDTH, underHeight);
        g.setColor(c);
        if (x == BIRD_X) {
            playerScore++;
            getPoint.play();
        }
        move();
    }

    private void move() {
        if (x > -BARRIER_WIDTH) {
            x -= SPEED;
        } else {
            x = SCREEN_WIDTH;
            init();
        }
    }

    public Rectangle getTopRec() {
        return new Rectangle(x, ty, BARRIER_WIDTH, topHeight);
    }

    public Rectangle getUnderRec() {
        return new Rectangle(x, uy, BARRIER_WIDTH, underHeight);
    }

    public static int getPlayerScore() {
        return playerScore;
    }

    public static void setPlayerScore(int playerScore) {
        Barrier.playerScore = playerScore;
    }

}
