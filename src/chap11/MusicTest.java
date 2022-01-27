package chap11;

/*
 *   CAN'T ADD CODE INBETWEEN TRY AND CATCH
 */


import javax.sound.midi.*;

public class MusicTest {

    public void play()
    {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
        }
        //System.out.println("heelo");  --> THROWS ERROR
        catch(MidiUnavailableException e)
        {

        }
        System.out.println("Bingo");
    }

    public static void main(String[] args)
    {
        MusicTest mt = new MusicTest();
        mt.play();
    }
}
