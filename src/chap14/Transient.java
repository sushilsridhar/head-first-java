package chap14;


import java.io.*;

public class Transient implements Serializable //extends TransientChild
{
    private int width;
    private int height;

    private transient TransientParent tp; // TO SKIP FROM SERIALIZATION

    public Transient(int w, int h, TransientParent tp)
    {
        this.width = w;
        this.height = h;
        this.tp = tp;
    }

    public static void main(String[] args)
    {
        Transient object = new Transient(10,20,new TransientParent());

        try
        {
            FileOutputStream fileStream = new FileOutputStream("src/chap14/Transient.ser");

            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(object);
            objectStream.close();
        }
        catch(FileNotFoundException e){ e.printStackTrace(); }
        catch(IOException e){ e.printStackTrace(); }
    }
}

class TransientParent //implements Serializable // child class inherits Serializable
{
    private int id;
}
