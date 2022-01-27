package chap13;

/*
 * javac List.java -Xlint:unchecked
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class List implements ListSelectionListener{

    JList<String> listBox;  // JList supports generics from java 7, compiler throws warning when <String> removed

    public static void main(String []args)
    {
        List list = new List();
        list.GUI();
    }

    public void GUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        String[] items = {"alpha", "beta", "gamma","delta", "epsilon","zeta","eta","theta"};
        listBox = new JList<String>(items);
        listBox.setVisibleRowCount(4);
        listBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listBox.addListSelectionListener(this);

        JScrollPane scroller = new JScrollPane(listBox);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller);

        frame.setSize(700,700);
        frame.setVisible(true);
    }

    public void valueChanged(ListSelectionEvent e)
    {
        //if(checkBox.isSelected())

        String selection = (String) listBox.getSelectedValue();
        System.out.println("Selected value is :"+selection);


    }
}

