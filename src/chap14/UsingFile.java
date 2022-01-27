package chap14;

/*
 * dir.delete() --> WILL DELETE ONLY IF DIRECTORY IS EMPTY
 */

import java.io.*;

public class UsingFile
{
    public static void main(String[] args)
    {
        File dir = new File("CreateDirectory");
        dir.mkdir();

        try {
            //FileOutputStream file = new FileOutputStream("CreateDirectory/dir.txt");
        }
        catch(Exception e) {}

        if(dir.isDirectory())
        {
            String[] dirContents = dir.list();
            for(int i=0; i< dirContents.length; i++)
            {
                System.out.println(dirContents[i]);
            }
        }

        System.out.println(dir.getAbsolutePath());

        boolean result = dir.delete();
        System.out.println("DELETED : "+ result);
    }
}
