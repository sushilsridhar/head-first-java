package chap13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextField implements ActionListener{

    JTextField field;
    JTextArea textArea;

    public static void main(String []args)
    {
        TextField textField = new TextField();
        textField.GUI();
    }

    public void GUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        frame.getContentPane().add(BorderLayout.EAST, panel);

        field = new JTextField("Hello World :D",20);
        panel.add(field);

        textArea = new JTextArea(10,20);

        JScrollPane scroller = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scroller);

        JButton button = new JButton("Click");
        button.addActionListener(this);
        panel.add(button);

        frame.setSize(700,700);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        textArea.append("welcome :P");
        //field.requestFocus();
        //field.selectAll();
    }
}

