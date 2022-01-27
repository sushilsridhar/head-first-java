package chap12;

import javax.swing.*;

public class FirstFrame {

    public static void main(String []args)
    {
        JFrame frame = new JFrame();
        JButton button = new JButton("Holla");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);

        frame.setSize(300,300);

        frame.setVisible(true);

    }
}
