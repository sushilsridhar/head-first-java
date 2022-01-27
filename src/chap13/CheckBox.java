package chap13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBox implements ItemListener{

    JCheckBox checkBox;

    public static void main(String []args)
    {
        CheckBox box = new CheckBox();
        box.GUI();
    }

    public void GUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        frame.getContentPane().add(BorderLayout.EAST, panel);

        checkBox = new JCheckBox();
        checkBox.addItemListener(this);
        panel.add(checkBox);

        frame.setSize(700,700);
        frame.setVisible(true);
    }

    public void itemStateChanged(ItemEvent ievent)
    {
        String onOrOff = "off";
        if(checkBox.isSelected())
        {
            onOrOff = "on";
            System.out.println("checkbox is :"+onOrOff);
        }

    }
}
