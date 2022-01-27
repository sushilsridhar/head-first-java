package chap14;

import java.io.*;

public class ReadAFile
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        File file = new File("ReadAFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = null;

        while((line = reader.readLine()) != null)
        {
            System.out.println(line);
        }

        reader.close();
    }
}
