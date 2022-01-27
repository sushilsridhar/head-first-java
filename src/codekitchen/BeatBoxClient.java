package codekitchen;

/**
 * --> FINAL VERSION
 */
import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class BeatBoxClient {

    JFrame frame;
    JPanel mainPanel;
    JTextArea incomingMessage;
    JTextArea outgoingMessage;
    ArrayList<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();

    String userName;

    //MIDI
    Sequencer sequencer;
    Sequence sequence;
    Track track;

    // NETWORK
    ObjectOutputStream out;
    ObjectInputStream in;
    BufferedReader reader;

    String[] instrumentNames = {"Bass Drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare","Crash Cymbal","Hand Clap","High Tom","Hi Bongo","Maracas","Whistle","Low Conga","Cowbell","Vibraslap","Low-mid Tom","High Agogo","Open Hi Conga"};

    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main(String[] args)
    {
        new BeatBoxClient().startUp(args[0]);
    }

    public void startUp(String name)
    {
        userName = name;

        setUpMidi(); // SETUP MIDI
        buildDisplay();

        try {
            Socket socket = new Socket("127.0.0.1",5000);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("hello1");
            Thread t = new Thread(new RecieveMessage()); //--> JOB IS TO RECIEVE MESSAGE
            t.start();
            System.out.println("hello2");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void setUpMidi()
    {
        try
        {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ,4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        }
        catch(Exception e) { e.printStackTrace(); }
    }


    public void buildDisplay()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel backGroundPanel = new JPanel(new BorderLayout()); // BACKGROUND PANEL
        backGroundPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); //MARGIN

        Box buttonBox = new Box(BoxLayout.Y_AXIS); // BUTTON BOX

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartListener());
        buttonBox.add(startButton);

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new StopListener());
        buttonBox.add(stopButton);

        JButton tempoUpButton = new JButton("Tempo Up");
        tempoUpButton.addActionListener(new TempoUpListener());
        buttonBox.add(tempoUpButton);

        JButton tempoDownButton = new JButton("Tempo Down");
        tempoDownButton.addActionListener(new TempoDownListener());
        buttonBox.add(tempoDownButton);

        JButton sendButton = new JButton("Send it");
        sendButton.addActionListener(new SendListener());
        buttonBox.add(sendButton);

        outgoingMessage = new JTextArea(6,10); // TYPE THE MESSAGE HERE
        outgoingMessage.setLineWrap(true);
        outgoingMessage.setWrapStyleWord(true);

        JScrollPane outgoingMessageScroller = new JScrollPane(outgoingMessage); // SCROLL BAR
        outgoingMessageScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        outgoingMessageScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        incomingMessage = new JTextArea(6,10); // DISPLAY INCOMING MESSAGE HERE
        incomingMessage.setLineWrap(true);
        incomingMessage.setWrapStyleWord(true);
        incomingMessage.setEditable(false);

        JScrollPane incomingMessageScroller = new JScrollPane(incomingMessage); // SCROLL BAR
        incomingMessageScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        incomingMessageScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        buttonBox.add(outgoingMessageScroller);
        buttonBox.add(incomingMessageScroller);

        Box nameBox = new Box(BoxLayout.Y_AXIS); // NAME BOX
        for(int i=0;i<16;i++)
        {
            nameBox.add(new Label(instrumentNames[i]));
        }

        backGroundPanel.add(BorderLayout.EAST, buttonBox); //ADD BUTTON BOX TO BACKGROUND PANEL
        backGroundPanel.add(BorderLayout.WEST, nameBox); // ADD NAME BOX TO BACKGROUND PANEL

        frame.getContentPane().add(backGroundPanel); // ADD PANEL TO FRAME

        GridLayout grid = new GridLayout(16,16); // GRID
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);

        for(int i=0;i<256;i++)
        {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setSelected(false);
            checkBoxList.add(checkBox);
            mainPanel.add(checkBox);
        }

        backGroundPanel.add(BorderLayout.CENTER, mainPanel); // ADD GRID TO BACKGROUND PANEL

        frame.setBounds(200,200,300,300);
        frame.pack();
        frame.setSize(700,500);
        frame.setVisible(true);
    }


    public void buildTrackAndStart()
    {
        int[] trackList = null;

        sequence.deleteTrack(track); // DELETE OLD TRACK
        track = sequence.createTrack();

        for(int i=0;i<16;i++)
        {
            trackList = new int[16];

            int key = instruments[i];

            for(int j=0;j<16;j++)
            {
                JCheckBox jc = (JCheckBox) checkBoxList.get(j + (16*i));
                if(jc.isSelected())
                {
                    trackList[j] = key;
                }
                else
                {
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(176,1,127,0,16));
        }
        track.add(makeEvent(176,1,127,0,16));

        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        }
        catch(Exception e) { e.printStackTrace(); }
    }

    public void makeTracks(int[] list)
    {
        for(int i=0;i<16;i++)
        {
            int key = list[i];
            if(key!=0)
            {
                track.add(makeEvent(144,9,key,100,i));
                track.add(makeEvent(128,9,key,100,i+1));
            }
        }
    }

    public MidiEvent makeEvent(int comd,int chan, int one, int two,int tick)
    {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        }
        catch(Exception e) { e.printStackTrace(); }
        return event;
    }

    class StartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            buildTrackAndStart();
        }
    }
    class StopListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            sequencer.stop();
        }
    }
    class TempoUpListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * 1.03));
        }
    }
    class TempoDownListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * .97));
        }
    }

    class SendListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            boolean[] checkBoxState = new boolean[256];

            for(int i = 0; i<256; i++)
            {
                JCheckBox jc = (JCheckBox) checkBoxList.get(i);
                if(jc.isSelected())
                {
                    checkBoxState[i] = true;
                }
            }

            try {
                System.out.println("outgoing message"+userName + ":" + outgoingMessage.getText());
                System.out.println("outgoing music"+checkBoxState);
                out.writeObject(userName + ":" + outgoingMessage.getText());
                out.writeObject(checkBoxState);
            }
            catch(Exception ex) {
                ex.printStackTrace(); }
        }
        //outgoingMessage.setText("");
    }

    class RecieveMessage implements Runnable
    {
        public void run()
        {
            System.out.println("hellothreade");
            String message = null;
            boolean checkBoxState[] = null;

            try {
                while((message = (String) in.readObject()) != null) {
                    System.out.println("incoming message"+message);
                    incomingMessage.append(message+"\n");
                    checkBoxState = (boolean[]) in.readObject();
                    System.out.println("incoming music"+checkBoxState);
                }
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }

            for(int i = 0; i<256; i++)
            {
                JCheckBox jc = (JCheckBox) checkBoxList.get(i);

                if(checkBoxState[i])
                {
                    jc.setSelected(true);
                }
                else
                    jc.setSelected(false);
            }

            sequencer.stop();
            buildTrackAndStart();
        }
    }
}
