package chap12;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GraphicsAppInner extends JPanel {

    JFrame frame;
    JLabel text;

    public static void main(String []args)
    {
        GraphicsAppInner gapp = new GraphicsAppInner();
        gapp.GUI();
    }

    public void GUI()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton changeColor = new JButton("Alsta-la-vista-Baby");
        frame.getContentPane().add(BorderLayout.SOUTH, changeColor); //adding button
        changeColor.addActionListener(new ChangeColor());


        frame.getContentPane().add(BorderLayout.CENTER, this); //adding Jpanel


        text = new JLabel("Hello world :D");
        frame.getContentPane().add(BorderLayout.NORTH, text);  // adding Label


        JButton changeText = new JButton("Change Message");
        frame.getContentPane().add(BorderLayout.EAST, changeText); //adding Button
        changeText.addActionListener(new ChangeText());

        frame.setSize(400,400);
        frame.setVisible(true);

    }

    class ChangeColor implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            repaint();
            //frame.repaint();
        }
    }

    class ChangeText implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            text.setText("Holla :D");
        }
    }

    protected void paintComponent(Graphics g)
    {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(60,60,100,100);
    }
}
