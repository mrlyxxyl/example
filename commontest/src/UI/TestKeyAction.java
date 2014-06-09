package UI;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestKeyAction {
    public static void main(String[] args) {
        JFrame frame = new JFrame("dd");
        JTextField textField = new JTextField();
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("press");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("release");
            }
        });
        frame.add(textField);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
