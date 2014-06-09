package UI;

import javax.swing.*;
import java.awt.*;

public class TestFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("my first frame");
        frame.setBounds(100, 100, 200, 200);
        JPanel panel = new JPanel();
        panel.setBackground(Color.blue);
        panel.setLayout(new GridLayout(2, 2));
        JButton button1 = new JButton("btn1");
        JButton button2 = new JButton("btn2");
        JButton button3 = new JButton("btn3");
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        frame.add(panel);
        frame.setVisible(true);
    }

}
