package chap12;

import java.awt.*;
import javax.swing.*;

public class DrawPanel extends JPanel {

    public static void main(String []args)
    {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new DrawPanel());


        frame.setSize(500,500);
        frame.setVisible(true);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // g.setColor(Color.orange);
        //g.fillRect(20,50,100,100);

        // Image image = new ImageIcon("image.jpg").getImage();
        //g.drawImage(image,3,4,this);

        g.fillRect(0,0,this.getWidth() , this.getHeight());

        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70,70,100,100);
    }
}
