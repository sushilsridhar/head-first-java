package chap14;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardGame
{
    JFrame frame;
    ArrayList<QuizCard> cardList;
    QuizCard currentCard;
    JTextArea display;
    JButton nextButton;
    int currentCardIndex;
    boolean isShowAnswer;

    public static void main(String[] args)
    {
        QuizCardGame qcg = new QuizCardGame();
        qcg.buildGui();
    }

    public void buildGui()
    {
        frame = new JFrame("Quiz Card");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(6,20); // QUESTION AND ANSWER
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        display.setFont(bigFont);
        display.setEditable(false);

        JScrollPane qScroller = new JScrollPane(display); // SCROLL BAR
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        nextButton = new JButton("Show Question");
        nextButton.addActionListener(new NextButtonListener());

        // ADD ALL TO MAIN PANEL
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);


        //ADD MENU BAR
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load Cards");
        loadMenuItem.addActionListener(new LoadButtonListener());

        menu.add(loadMenuItem);
        menuBar.add(menu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);
    }

    class LoadButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser chooseFile = new JFileChooser(); // DIALOG BOX
            chooseFile.showOpenDialog(frame);
            readFile(chooseFile.getSelectedFile()); // SELECTS THE FILE
        }
    }

    public void readFile(File file)
    {
        cardList = new ArrayList<QuizCard>();
        try
        {
            BufferedReader bufferReader = new BufferedReader(new FileReader(file));
            String line = null;

            while((line = bufferReader.readLine()) != null)
            {
                if(line.trim().length() == 0) // CHECKS IF LINE IS EMPTY SPACE
                {
                    System.out.println("Take a break");
                    break;
                }
                makeACard(line.trim());
            }
            bufferReader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        showCard();
    }

    private void makeACard(String line)
    {
        String[] results = line.split("/");
        QuizCard quizCard = new QuizCard(results[0], results[1]);
        cardList.add(quizCard);
    }

    private void showCard()
    {
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }


    class NextButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(isShowAnswer)
            {
                display.setText(currentCard.getAnswer());
                nextButton.setText("Show next Question");
                isShowAnswer = false;
            }
            else
            {
                if(currentCardIndex < cardList.size())
                {
                    showCard();
                }
                else
                {
                    display.setText("That was Last Card");
                    nextButton.setEnabled(false);
                }
            }
        }
    }
}


