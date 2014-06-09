package flappybird;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;

import flappybird.data.*;

public class Game implements Parameter {
    private static final int INT_X_FORMER = SCREEN_WIDTH;
    private static final int INT_X_LATER = SCREEN_WIDTH + SCREEN_WIDTH_HALF + BARRIER_WIDTH / 2;
    private static final int INT_Y = TITLE_BAR_HEIGHT;

    private static AudioClip jump = Applet.newAudioClip(Barrier.class
            .getClassLoader().getResource("flappybird/music/jump.wav"));
    private static AudioClip backGroundMusic = Applet.newAudioClip(Barrier.class
            .getClassLoader().getResource("flappybird/music/backgroundmusic.wav"));

    private Bird bird = new Bird(BIRD_X, BIRD_Y);
    private Ground ground = new Ground();
    private Barrier bf = new Barrier(INT_X_FORMER, INT_Y);
    private Barrier bl = new Barrier(INT_X_LATER, INT_Y);

    private Font f1 = new Font("ºÚÌå", Font.BOLD, 60);
    private Font f2 = new Font("ºÚÌå", Font.BOLD, 80);

    private WindowFrame wf = null;
    private LeaderBoard lb = null;

    public Game(WindowFrame wf, LeaderBoard lb) {
        this.wf = wf;
        this.lb = lb;
        backGroundMusic.loop();
    }

    public void initGame() {
        bird = new Bird(BIRD_X, BIRD_Y);
        bf = new Barrier(INT_X_FORMER, INT_Y);
        bl = new Barrier(INT_X_LATER, INT_Y);
        ground = new Ground();
        Barrier.setPlayerScore(0);
    }

    public void launchGame(Graphics g) {
        if (bird.isAlive()) {
            bird.drawBird(g);
            bird.collideBarrier(bf);
            bird.collideBarrier(bl);
            bird.collideGround(ground);
            ground.drawGround(g);
            bf.drawBarrier(g);
            bl.drawBarrier(g);
            Font f = g.getFont();
            Color c = g.getColor();
            g.setFont(f1);
            g.setColor(Color.ORANGE);
            String score = String.valueOf(Barrier.getPlayerScore());
            g.drawString(score, SCREEN_WIDTH / 2 - g.getFontMetrics().stringWidth(score), 100);
            g.setColor(c);
            g.setFont(f);
        } else {
            Font f = g.getFont();
            Color c = g.getColor();
            g.setFont(f2);
            FontMetrics fm = g.getFontMetrics();
            String score = String.valueOf(Barrier.getPlayerScore());
            int stringWidth = fm.stringWidth("SCORE£º" + score);
            int stringAscent = fm.getAscent();
            int stringDescent = fm.getDescent();
            int stringX = (SCREEN_WIDTH - stringWidth) / 2;
            int stringY = (SCREEN_HEIGHT - (stringAscent + stringDescent)) / 2;
            g.setColor(Color.ORANGE);
            g.drawString("SCORE£º" + score, stringX, stringY);
            g.setColor(c);
            g.setFont(f);
        }
    }

    public void playerPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (bird.isAlive()) {
                bird.initJump();
                bird.setJumping(true);
                jump.play();
            } else {
                if (wf.isBeginGame()) {
                    wf.setBeginGame(false);
                    lb.save(Barrier.getPlayerScore());
                    initGame();
                }
            }
        }
    }

}
