package chap15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

class ChatClient {

    JTextField outgoing;
    JTextArea incoming;

    BufferedReader reader;
    PrintWriter writer;

    void buildChatScreen()
    {
        JFrame frame = new JFrame("Chat Room");
        JPanel panel = new JPanel();

        //----> TEXT AREA
        incoming = new JTextArea(15,50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);

        // ----> SCROLL BAR
        JScrollPane scrollPane = new JScrollPane(incoming);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // --- > TEXT FIELD
        outgoing = new JTextField(20);

        //---->> SEND BUTTON
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());


        panel.add(scrollPane);
        panel.add(outgoing);
        panel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        setUpNetworking();

        Thread recieverThread = new Thread(new MessageRecieverJob());
        recieverThread.start();

        frame.setVisible(true);
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void setUpNetworking()
    {
        try {
            Socket socket = new Socket("127.0.0.1",5000);
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Network established");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    class SendButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("message content : "+outgoing.getText());
            if(outgoing.getText() != null)
            {

                writer.println(outgoing.getText());
                writer.flush();
            }
            else
                outgoing.setText("enter message");

            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    class MessageRecieverJob implements Runnable
    {
        public void run()
        {
            String message;
            try{
                while((message = reader.readLine()) != null)
                {
                    System.out.println("incoming message : "+message);
                    incoming.append(message+"\n");
                }
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args)
    {
        ChatClient client = new ChatClient();
        client.buildChatScreen();
    }
}
