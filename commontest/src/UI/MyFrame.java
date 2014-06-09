package UI;

import java.awt.*;

class MyFrame extends Frame {

    public MyFrame() {
        setBounds(100, 100, 300, 300);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(30, 30, 40, 40);
        g.setColor(Color.blue);
        g.fillRect(100, 100, 20, 20);
        g.setColor(c);
    }
}
