package chap14;

/*
 * STATIC VARIABLES ARE NOT SERIALIZED
 *
 */

import java.io.*;

public class DeSerialization implements Serializable
{
    private int width;
    static private int height;

    public DeSerialization(int w, int h)
    {
        this.width = w;
        this.height = h;
    }

    public static void serializeObject() throws FileNotFoundException,IOException
    {
        DeSerialization object = new DeSerialization(10,20);
        DeSerialization objectOne = new DeSerialization(30,40);

        FileOutputStream outputStream = new FileOutputStream("src/chap14/DeSerialization.ser");

        ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);
        objectStream.writeObject(object);
        objectStream.writeObject(objectOne);

        objectStream.close();

    }

    public static void deserializeObject() throws FileNotFoundException,IOException,ClassNotFoundException
    {
        FileInputStream inputStream = new FileInputStream("src/chap14/DeSerialization.ser");

        ObjectInputStream objectStream = new ObjectInputStream(inputStream);

        DeSerialization object = (DeSerialization) objectStream.readObject();
        DeSerialization objectOne = (DeSerialization) objectStream.readObject();

        objectStream.close();

        System.out.println(object.width);
        System.out.println(objectOne.width);
        System.out.println(object.height);
        System.out.println(objectOne.height);
    }

    public static void main(String[] args)
    {
        try
        {
            serializeObject();
            deserializeObject();
        }
        catch(FileNotFoundException e) {e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ClassNotFoundException e){e.printStackTrace();}
    }
}
