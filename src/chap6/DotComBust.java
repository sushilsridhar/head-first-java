package chap6;

import java.util.ArrayList;

public class DotComBust {

    private GameHelper gh = new GameHelper();
    private ArrayList<DotCom> dcList = new ArrayList<DotCom>();
    private int noOfGuess = 0;

    public void setUpGame()
    {
        DotCom dcOne = new DotCom();
        dcOne.setName("Airbnb.com");
        DotCom dcTwo = new DotCom();
        dcOne.setName("Amazon.com");
        DotCom dcThree = new DotCom();
        dcOne.setName("Pepperfry.com");

        dcList.add(dcOne);
        dcList.add(dcTwo);
        dcList.add(dcThree);

        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Airbnb.com, Amazon.com, Pepperfry.com");
        System.out.println("Try to sink all of them in fewer number of guesses");

        for(DotCom dc : dcList)
        {
            ArrayList<String> newLocation = gh.placeDotCom(3);
            dc.setLocations(newLocation);
        }
    }

    public void startPlaying()
    {
        while(!dcList.isEmpty())
        {
            String userGuess = gh.getUserInput();
            checkUserGuess(userGuess);
            finishGame();
        }
    }

    public void checkUserGuess(String userGuess)
    {
        noOfGuess++;

        String results = null;

        for(DotCom dc : dcList)
        {
            results = dc.checkYourself(userGuess);

            if(results.equals("HIT"))
                break;
            else if(results.equals("KILL"))
            {
                dcList.remove(dc);
                break;
            }
        }
        System.out.println(results);
    }

    public void finishGame()
    {
        System.out.println("-------- GAME OVER --------");

        if(noOfGuess <= 18)
        {
            System.out.println("You Nailed it! :D :"+ noOfGuess);
        }
        else
            System.out.println("Need Some Training!" + noOfGuess);

    }

    public static void main(String[] args)
    {
        DotComBust dotComBust = new DotComBust();
        dotComBust.setUpGame();

        dotComBust.startPlaying();

    }
}
