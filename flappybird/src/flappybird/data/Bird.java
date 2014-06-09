package flappybird.data;

import java.applet.*;
import java.awt.*;
import java.util.*;

import flappybird.Parameter;

public class Bird implements Parameter {
    private static final int BEGIN_DROP_SPEED = 1;
    private static final int BEGIN_JUMP_SPEED = 5;

    private static Toolkit tk = Toolkit.getDefaultToolkit();
    private static Image[] imgs = new Image[]{
            tk.getImage(Bird.class.getClassLoader().getResource(
                    "flappybird/images/bird.png")),
            tk.getImage(Bird.class.getClassLoader().getResource(
                    "flappybird/images/jbird.png")),
            tk.getImage(Bird.class.getClassLoader().getResource(
                    "flappybird/images/dbird.png"))};
    private static Map<String, Image> birdImg = new HashMap<String, Image>();
    private static AudioClip dead = Applet.newAudioClip(Barrier.class.getClassLoader().getResource("flappybird/music/dead.wav"));

    static {
        birdImg.put("nor", imgs[0]);
        birdImg.put("jump", imgs[1]);
        birdImg.put("drop", imgs[2]);
    }

    private int x, y;
    private boolean alive = true;
    private boolean isJumping = false;
    private int jumpSpeed = BEGIN_JUMP_SPEED;
    private int dropSpeed = BEGIN_DROP_SPEED;

    private int timer = 0;

    public Bird(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawBird(Graphics g) {
        if (timer > 100) {
            timer = 0;
        } else {
            timer++;
        }
        if (isJumping) {
            g.drawImage(birdImg.get("jump"), x, y, null);
        } else {
            g.drawImage(birdImg.get("drop"), x, y, null);
        }

        if (timer % 4 == 0 && !isJumping) {
            drop();
        } else if (timer % 4 == 0 && isJumping) {
            jump();
        }
    }

    public void collideBarrier(Barrier b) {
        if (getRec().intersects(b.getTopRec()) || getRec().intersects(b.getUnderRec())) {
            alive = false;
            dead.play();
        }
    }

    public void collideGround(Ground g) {
        if (getRec().intersects(g.getRec())) {
            alive = false;
            dead.play();
        }
        if (y < TITLE_BAR_HEIGHT) {
            alive = false;
            dead.play();
        }
    }

    private void drop() {
        y += dropSpeed;
        if (timer % 3 == 0) {
            dropSpeed += 1;
        }
    }

    private void jump() {
        y -= jumpSpeed;
        if (timer % 3 == 0) {
            jumpSpeed -= 1;
        }
        if (jumpSpeed <= 0) {
            isJumping = false;
            initDrop();
        }
    }

    public void initJump() {
        jumpSpeed = BEGIN_JUMP_SPEED;
    }

    private void initDrop() {
        dropSpeed = BEGIN_DROP_SPEED;
    }

    public void setJumping(boolean isJumping) {
        this.isJumping = isJumping;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public Rectangle getRec() {
        return new Rectangle(x, y, BIRD_WIDTH, BIRD_HEIGHT);
    }

    public boolean isAlive() {
        return alive;
    }

}
