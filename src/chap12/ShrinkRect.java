package chap12;

import java.awt.*;
import javax.swing.*;

public class ShrinkRect extends JPanel {
    int x = 1;
    int y = 1;

    public static void main(String []args)
    {
        ShrinkRect shrinkRect = new ShrinkRect();
        shrinkRect.animate();
    }

    public void animate()
    {
        JFrame frame = new JFrame();

        frame.getContentPane().add(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,270);
        frame.setVisible(true);

        for(int i=0; i<124;i++,x++,y++)
        {
            x++;
            repaint();
            try {
                Thread.sleep(50);
            }
            catch(Exception ex){ }
        }
    }

    protected void paintComponent(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0,0,500,250);
        g.setColor(Color.blue);
        g.fillRect(x,y,500-x*2,250-y*2);
    }
}
