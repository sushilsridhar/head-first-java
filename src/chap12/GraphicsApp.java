package chap12;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GraphicsApp extends JPanel implements ActionListener {

    JLabel text;

    public static void main(String []args)
    {
        GraphicsApp gapp = new GraphicsApp();
        gapp.GUI();
    }

    public void GUI()
    {
        JFrame frame = new JFrame();
        JButton changeColor = new JButton("Alsta-la-vista-Baby");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(BorderLayout.SOUTH, changeColor); //adding button

        changeColor.addActionListener(this);

        frame.getContentPane().add(BorderLayout.CENTER, this); //adding Jpanel

        text = new JLabel("Hello world :D");
        frame.getContentPane().add(BorderLayout.WEST, text);

        JButton changeText = new JButton("Change Message");
        frame.getContentPane().add(BorderLayout.EAST, changeText);


        changeText.addActionListener(this);

        frame.setSize(400,400);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        //System.out.println(command);

        if(command.equals("Alsta-la-vista-Baby"))
            repaint();
        else if(command.equals("Change Message"))
            text.setText("Holla World :P");
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
