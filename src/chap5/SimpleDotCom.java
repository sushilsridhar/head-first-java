package chap5;


public class SimpleDotCom {

    int hitCount;
    int locations[];

    public int[] getLocations()
    {
        return locations;
    }

    public void setLocations(int[] loc)
    {
        this.locations = loc;
    }

    String checkYourself(String guess)
    {
        int g = Integer.parseInt(guess);
        System.out.println("Your guess: "+ g);

        String results = "Miss :(";

        for(int l : locations)
        {
            System.out.println("locations : "+ l);
            if(g == l)
            {
                results = "HIT";
                break;
            }
        }


        //System.out.println("------------- HitCount : "+hitCount);
        return results;
    }

    /*public static void main(String[] args)
    {
        SimpleDotCom sdc = new SimpleDotCom();

        int[] loc = {2,3,4};
        sdc.setLocations(loc);

        int userGuess[] = {2,1,4};

        for(int g : userGuess)
        {
            String result = sdc.checkYourself(g);
            System.out.println("Result : "+result);
        }
    } */
}
