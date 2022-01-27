package chap14;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardPlayer
{
    // FOR CARDLAYOUT
    final static String MAIN_PANEL = "main_panel";
    final static String GAME_PANEL = "game_panel";

    JFrame frame;
    ArrayList<QuizCard> cardList;
    JTextArea question;
    JTextArea answer;
    JPanel cards;

    public static void main(String[] args)
    {
        QuizCardPlayer qcp = new QuizCardPlayer();
        qcp.buildGui();
    }

    public void buildGui()
    {
        frame = new JFrame("Quiz Card");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        question = new JTextArea(6,20); // QUESTIONS
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane qScroller = new JScrollPane(question); // QUESTIONS SCROLL BAR
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        answer = new JTextArea(6,20); // ANSWERS
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        JScrollPane aScroller = new JScrollPane(answer); // ANSWERS SCROLL BAR
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        cardList = new ArrayList<QuizCard>();

        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(new NextButtonListener());

        JLabel qlabel = new JLabel("Question:");
        JLabel alabel = new JLabel("Answer:");

        // ADD ALL TO MAIN PANEL
        mainPanel.add(qlabel);
        mainPanel.add(qScroller);
        mainPanel.add(alabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);


        //ADD MENU BAR
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(new NewButtonListener());
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new SaveButtonListener());
        JMenuItem playMenuItem = new JMenuItem("Play Game");
        playMenuItem.addActionListener(new PlayGameListener());

        menu.add(newMenuItem);
        menu.add(saveMenuItem);
        menu.add(playMenuItem);

      /*  JMenu menuTwo = new JMenu("Play Game");
        menuTwo.addActionListener(new PlayGameListener()); */
        menuBar.add(menu);
        //menuBar.add(menuTwo);

        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
        //USING CARD LAYOUT
        cards = new JPanel(new CardLayout());
        cards.add(card1, MAIN_PANEL);
        cards.add(card2, GAME_PANEL);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, cards);
        frame.setSize(500,600);
        frame.setVisible(true);
    }

    class NextButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            QuizCard quizCard = new QuizCard(question.getText(), answer.getText());
            cardList.add(quizCard);
            clearCard();
        }
    }

    class NewButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            cardList.clear();
            clearCard();
        }
    }

    class SaveButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            QuizCard quizCard = new QuizCard(question.getText(), answer.getText());
            cardList.add(quizCard);

            JFileChooser fileSave = new JFileChooser(); // DIALOG BOX
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile()); // SELECTS THE FILE

            clearCard();
        }
    }

    public void clearCard()
    {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    public void saveFile(File file)
    {
        try
        {
            BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file));

            for(QuizCard qc: cardList)
            {
                bufferWriter.write(qc.getQuestion()+ "/");
                bufferWriter.write(qc.getAnswer()+ "\n");
            }
            bufferWriter.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    class PlayGameListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("hello");
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, GAME_PANEL) ;
            System.out.println(GAME_PANEL);
        }
    }
}


