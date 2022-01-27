package chap12;

import javax.swing.*;
import java.awt.*;

public class Animation {

    JFrame frame;
    int xCoordinate = 50;
    int yCoordinate = 55;

    public static void main(String[] args)
    {
        Animation animation = new Animation();
        animation.moveItem();
    }

    public void moveItem()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.getContentPane().add(new Item()); //adding Jpanel

        frame.setSize(600,600);
        frame.setVisible(true);


        for(int i=0; i<300; i++)
        {
            xCoordinate++;
            yCoordinate++;
            frame.repaint();

            try {
                Thread.sleep(50);
            }
            catch(Exception ex)
            {

            }
        }
    }

    class Item extends JPanel{

        protected void paintComponent(Graphics g)
        {
           /* g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight()); */

            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);

            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);
            System.out.println(xCoordinate);
            g.fillOval(xCoordinate,yCoordinate+5,100,100);
        }
    }

}
