package six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {

    public String getUserInput()
    {
        String inputLine = null;
        System.out.println("enter your Guess :");

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

    public ArrayList<String> placeDotCom(int lenOfDotCom)
    {
        int randomNumber = (int) (Math.random()*4);
        System.out.println("Random Number: "+randomNumber);

        int[] loc = {randomNumber,randomNumber+1,randomNumber+2};
        //sdc.setLocations(loc);
        return null;
    }

}
