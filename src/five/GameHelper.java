package five;

import java.io.*;

public class GameHelper {

    public String getUserInput()
    {
        String inputLine = null;
        System.out.println("enter a number :");

        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));

            inputLine = is.readLine();

            if(inputLine.length() == 0)
                return null;
        }
        catch(IOException e)
        {
            System.out.println("Exception : "+ e);
        }
        return inputLine;
    }

}
