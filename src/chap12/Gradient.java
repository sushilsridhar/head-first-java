package chap12;

import java.awt.*;
import javax.swing.*;

public class Gradient extends JPanel {

    public static void main(String []args)
    {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new Gradient());


        frame.setSize(500,500);
        frame.setVisible(true);
    }

    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(70,70, Color.blue, 150,150, Color.orange);

        g2d.setPaint(gradient);

        g2d.fillRect(70,70,100,100);

       /* int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70,70,100,100); */
    }
}
