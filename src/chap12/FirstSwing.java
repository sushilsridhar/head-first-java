package chap12;


import javax.swing.*;
import java.awt.event.*;

public class FirstSwing implements ActionListener {

    JButton button;

    public static void main(String []args)
    {
        FirstSwing fswing = new FirstSwing();
        fswing.GUI();
    }

    public void GUI()
    {
        JFrame frame = new JFrame();
        button = new JButton("Alsta-la-vista-Baby");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);

        frame.setSize(300,300);
        frame.setVisible(true);

        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
    {
        button.setText("I will be Back!");
    }
}

