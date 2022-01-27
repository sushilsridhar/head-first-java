package chap14;

/*
 * STATIC VARIABLES ARE NOT SERIALIZED ---> value loaded from class durning deserialization
 *
 * serialVersionUID is a special type of static variable --> it is serialized
 *
 * Static transient String name = "Hello"; --> loaded from class durning deserialization because of static keyword
 * final transient String name = "hello"; --> this is will be serialized because of final keyword
 *
 * TRANSIENT DOESNOT WORK WITH FINAL AND STATIC KEYWORDS
 *
 * USE serialver space class name to generate a serialVersionUID if you want to create serialVersionUID manually
 */

import java.io.*;

public class FinalVariable implements Serializable
{
    private int width;
    final private int height;

    public FinalVariable(int w, int h)
    {
        this.width = w;
        this.height = h;
    }

    public static void serializeObject() throws FileNotFoundException,IOException,ClassNotFoundException
    {
        FinalVariable object = new FinalVariable(100,200);
        FinalVariable objectOne = new FinalVariable(300,400);

        FileOutputStream outputStream = new FileOutputStream("src/chap14/FinalVariable.ser");

        ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);
        objectStream.writeObject(object);
        objectStream.writeObject(objectOne);

        objectStream.close();

    }

    public static void deserializeObject() throws FileNotFoundException,IOException,ClassNotFoundException
    {
        FileInputStream inputStream = new FileInputStream("src/chap14/FinalVariable.ser");

        ObjectInputStream objectStream = new ObjectInputStream(inputStream);

        FinalVariable object = (FinalVariable) objectStream.readObject();
        FinalVariable objectOne = (FinalVariable) objectStream.readObject();

        objectStream.close();

        System.out.println(object.width);
        System.out.println(object.height);
        System.out.println(objectOne.width);
        System.out.println(objectOne.height);
    }

    public static void main(String[] args)
    {
        try
        {
            //serializeObject();
            deserializeObject(); // VALUE OF STATIC VARIABLE IS 0 , NOT 500 ---> 500 DOESNOT GET SAVED IN FILE
        }
        catch(FileNotFoundException e) {e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ClassNotFoundException e){e.printStackTrace();}
    }
}
