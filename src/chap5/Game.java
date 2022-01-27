package chap5;

import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;


public class Game {
    public static void main(String[] args)
    {
        int noOfGuess = 0;
        Boolean isAlive = true;

        SimpleDotCom sdc = new SimpleDotCom();

        int randomNumber = (int) (Math.random()*4);
        System.out.println("Random Number: "+randomNumber);

        int[] loc = {randomNumber,randomNumber+1,randomNumber+2};
        sdc.setLocations(loc);

        //int userGuess[] = {2,1,4}; //get input from user

        GameHelper gameHelper = new GameHelper();

       /* int[] intArray = { 1, 2, 3, 4, 5 };
        int[] removed = ArrayUtils.removeElement(intArray, 3);//create a new array
        System.out.println(Arrays.toString(removed)); */

        while(isAlive)
        {
            String userInput = gameHelper.getUserInput();

            String result = sdc.checkYourself(userInput);
            noOfGuess++;

            System.out.println("------------- Result : "+result);

            if(result.equals("HIT"))
            {
                int[] newArray = ArrayUtils.removeElement(sdc.getLocations(),Integer.parseInt(userInput));
                System.out.println("new Locations:"+ Arrays.toString(newArray));

                if(newArray.length == 0)
                {
                    isAlive = false;
                    System.out.println("------------- KILL");
                    System.out.println("------------- GAME OVER -------------");
                    System.out.println("no of guess: "+ noOfGuess);
                }

                sdc.setLocations(newArray);
            }
               /* if(result.equals("KILL"))
                {
                    isAlive = false;
                    System.out.println("no of guess: "+ noOfGuess);
                } */

            System.out.println("isAlive :"+ isAlive);

        }

    }
}
