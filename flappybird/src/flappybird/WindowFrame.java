package flappybird;

import flappybird.data.Bird;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class WindowFrame extends Frame implements Parameter {
    private boolean exitFlag = false;
    private boolean beginGame = false;

    private Color backGroundColor = new Color(188, 255, 255);

    private LeaderBoard lb = new LeaderBoard();
    private Game game = new Game(this, lb);

    private Image offScreenImage = null;

    public void paint(Graphics g) {
        if (beginGame) {
            game.launchGame(g);
        } else {
            Font f = g.getFont();
            Color c = g.getColor();
            g.drawImage(Toolkit.getDefaultToolkit().getImage(Bird.class.getClassLoader().getResource("flappybird/images/bird.png")), BIRD_X, BIRD_Y, null);
            Font f2 = new Font("ºÚÌå", Font.BOLD, 100);
            g.setFont(f2);
            FontMetrics fm = g.getFontMetrics();
            int stringWidth = fm.stringWidth("FLAPPY BIRD");
            int stringAscent = fm.getAscent();
            int stringDescent = fm.getDescent();
            int stringX = (SCREEN_WIDTH - stringWidth) / 2;
            int stringY = (SCREEN_HEIGHT - (stringAscent + stringDescent)) / 2 - stringAscent / 2;
            g.setColor(Color.ORANGE);
            g.drawString("FLAPPY BIRD", stringX, stringY);
            f2 = new Font("ºÚÌå", Font.BOLD, 40);
            g.setFont(f2);
            fm = g.getFontMetrics();
            stringWidth = fm.stringWidth("Press SPACE to continue");
            stringAscent = fm.getAscent();
            stringDescent = fm.getDescent();
            stringX = (SCREEN_WIDTH - stringWidth) / 2;
            stringY = (SCREEN_HEIGHT - (stringAscent + stringDescent)) / 2 + stringAscent * 5;
            g.setColor(Color.ORANGE);
            g.drawString("Press SPACE to continue", stringX, stringY);
            // leaderboard
            f2 = new Font("ºÚÌå", Font.BOLD, 20);
            g.setFont(f2);
            String score = String.valueOf(lb.load());
            fm = g.getFontMetrics();
            stringWidth = fm.stringWidth("YOUR BEST:" + score);
            stringAscent = fm.getAscent();
            stringDescent = fm.getDescent();
            g.setColor(new Color(128, 64, 0)); // color brown
            int leaderBoardWidth = stringWidth + 30;
            int leaderBoardHeight = stringAscent + stringDescent + 20;
            int leaderBoardX = (SCREEN_WIDTH - leaderBoardWidth) / 2;
            int leaderBoardY = (SCREEN_HEIGHT - leaderBoardHeight) / 2;
            g.fillRoundRect(leaderBoardX, leaderBoardY, leaderBoardWidth, leaderBoardHeight, 10, 10);

            g.setColor(Color.WHITE);
            stringX = (SCREEN_WIDTH - stringWidth) / 2;
            stringY = (SCREEN_HEIGHT - (stringAscent + stringDescent)) / 2 + stringAscent;
            g.drawString("YOUR BEST:" + score, stringX, stringY);
            g.setColor(c);
            g.setFont(f);
        }
    }

    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
        }
        Graphics gOffScreenImage = offScreenImage.getGraphics();
        Color c = gOffScreenImage.getColor();
        gOffScreenImage.setColor(backGroundColor);
        gOffScreenImage.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        gOffScreenImage.setColor(c);
        paint(gOffScreenImage);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    private void exit() {
        exitFlag = true;
        System.exit(0);
    }

    public void launchFrame() {
        new Thread(new Runnable() {
            public void run() {
                while (!exitFlag) {
                    repaint();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (beginGame) {
                    game.playerPressed(e);
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    beginGame = true;
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setBackground(backGroundColor);
        setResizable(false);
        setTitle("Flappy Bird By Wbq");
        setVisible(true);
    }

    public boolean isBeginGame() {
        return beginGame;
    }

    public void setBeginGame(boolean beginGame) {
        this.beginGame = beginGame;
    }

}
