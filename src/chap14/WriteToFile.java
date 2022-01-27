package chap14;

import java.io.*;

public class WriteToFile
{
    public static void main(String[] args)
    {
        try
        {
            FileWriter fileWriter = new FileWriter("src/chap14/WriteToFile.txt");
            fileWriter.write("Hello World :D :P");
            fileWriter.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
