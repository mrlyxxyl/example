package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class TestAction {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ÊÂ¼þ");
        JButton button = new JButton("click two");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
    }
}
