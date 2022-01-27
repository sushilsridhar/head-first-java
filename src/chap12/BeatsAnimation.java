package chap12;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class BeatsAnimation {
    JFrame frame = new JFrame("Beats Animation");

    static int i = 0;
    boolean msg = false;
    BeatsGraphics bg;

    public static void main(String[] args)
    {
        BeatsAnimation beatsAnimation = new BeatsAnimation();
        beatsAnimation.play(); // play sound
    }

    public void setupGUI()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bg = new BeatsGraphics();
        frame.getContentPane().add(BorderLayout.CENTER, bg); //add content pane to frame
        //frame.setBounds(30,30, 300,300);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public void play()
    {
        setupGUI();

        try
        {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            int [] eventsIWant = {127};
            player.addControllerEventListener(bg, eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            for(int i = 5; i<61; i+=4)
            {
                track.add(createMidiEvent(144, 1, i, 100, i));

                track.add(createMidiEvent(176, 1, 127, 0, i)); //127 is controller event

                track.add(createMidiEvent(128, 1, i, 100, i+2));
            }

            player.setSequence(seq);
            player.start();
            //player.setTempoInBPM(120);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    static MidiEvent createMidiEvent(int cmd, int chan, int one, int two, int tick) throws InvalidMidiDataException
    {
        ShortMessage a = new ShortMessage();
        a.setMessage(cmd, chan, one, two);
        MidiEvent event = new MidiEvent(a, tick);
        return event;
    }

    class BeatsGraphics extends JPanel implements ControllerEventListener
    {
        public void controlChange(ShortMessage sm)
        {
            msg = true;
            if(msg)
            {
                System.out.println("La-la-land");
                repaint();
            }

        }
        protected void paintComponent(Graphics g)
        {
            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);

            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);

            //int top = (int) (Math.random() * 100 + 20);
            int len = (int) (Math.random() * 100 + 20);
            int bre = (int) (Math.random() * 100 + 20);
            //L T LEN BRE

            g.fillRect(200+ ++i,100,len,bre);
            msg = false;
        }

    }
}
