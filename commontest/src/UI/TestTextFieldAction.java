package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestTextFieldAction {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TextFeild");
        JPasswordField passwordField = new JPasswordField();
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPasswordField passwordField1 = (JPasswordField) e.getSource();
                System.out.println(passwordField1.getText());
                passwordField1.setText("");
            }
        });
        frame.add(passwordField);
        frame.pack();
        frame.setVisible(true);
    }
}

