package chap14;

/*
 * SERIALIZATION IS ALL OR NOTHING
 * ENTIRE GRAPH GETS SAVED OR SERIALIZATION FAILS
 */

import java.io.*;

public class FirstSerialization implements Serializable
{
    private int width;
    private int height;

    public FirstSerialization(int w, int h)
    {
        this.width = w;
        this.height = h;
    }

    public static void main(String[] args)
    {
        FirstSerialization object = new FirstSerialization(10,20);

        try
        {
            FileOutputStream fileStream = new FileOutputStream("src/chap14/FirstSerialization.ser");

            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(object);
            objectStream.close();
        }
        catch(FileNotFoundException e)
        {

        }
        catch(IOException e)
        {

        }

    }
}
