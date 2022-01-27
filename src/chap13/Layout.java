package chap13;

/*
 *   Default layout for panel is FlowLayout which places components in single line
 */

import javax.swing.*;
import java.awt.*;

public class Layout {

    public static void main(String []args)
    {
        Layout layout = new Layout();
        layout.GUI();
    }

    public void GUI()
    {
        JFrame frame = new JFrame();
        JButton button = new JButton("Alsta-la-vista-Baby");
        JButton onebutton = new JButton("hello world");
        JButton twobutton = new JButton("bliss");
        JButton threebutton = new JButton("huh?");

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(button);
        panel.add(onebutton);
        panel.add(twobutton);
        panel.add(threebutton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(BorderLayout.EAST, panel);

        frame.setSize(500,500);
        frame.setVisible(true);
    }
}

