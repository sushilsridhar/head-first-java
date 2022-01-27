package chap14;

/*
 * STATIC VARIABLES ARE NOT SERIALIZED ---> value loaded from class durning deserialization
 *
 * serialization UID is a special type of static variable --> it is serialized
 *
 * Static transient String name = "Hello"; --> loaded from class durning deserialization because of static keyword
 * final transient String name = "hello"; --> this is will be serialized because of final keyword
 *
 * TRANSIENT DOESNOT WORK WITH FINAL AND STATIC KEYWORDS
 */

import java.io.*;

public class StaticVariable implements Serializable
{
    private int width;
    static private int height;

    public StaticVariable(int w)
    {
        this.width = w;
    }

    public static void serializeObject() throws FileNotFoundException,IOException
    {
        StaticVariable object = new StaticVariable(10);
        object.height = 500;
        StaticVariable objectOne = new StaticVariable(30);

        FileOutputStream outputStream = new FileOutputStream("src/chap14/StaticVariable.ser");

        ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);
        objectStream.writeObject(object);
        objectStream.writeObject(objectOne);

        objectStream.close();

    }

    public static void deserializeObject() throws FileNotFoundException,IOException,ClassNotFoundException
    {
        FileInputStream inputStream = new FileInputStream("src/chap14/StaticVariable.ser");

        ObjectInputStream objectStream = new ObjectInputStream(inputStream);

        StaticVariable object = (StaticVariable) objectStream.readObject();
        StaticVariable objectOne = (StaticVariable) objectStream.readObject();

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
            // serializeObject();
            deserializeObject(); // VALUE OF STATIC VARIABLE IS 0 , NOT 500 ---> 500 DOESNOT GET SAVED IN FILE
        }
        catch(FileNotFoundException e) {e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ClassNotFoundException e){e.printStackTrace();}
    }
}
