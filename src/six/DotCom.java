package six;

import java.util.ArrayList;

public class DotCom {
    String name;
    ArrayList<String> locations;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<String> getLocations()
    {
        return locations;
    }

    public void setLocations(ArrayList<String> locations)
    {
        this.locations = locations;
    }

    String checkYourself(String guess)
    {
        int g = Integer.parseInt(guess);
        System.out.println("Your guess: "+ g);

        String results = "MISS";

        int index = locations.indexOf(g);

        if(index >= 0)
        {
            locations.remove(index);

            if(locations.isEmpty())
            {
                results = "KILL";
                System.out.println("Ouch! you sunk the ship "+ name +" :( ");
            }
            else
                results = "HIT";
        }

        return results;
    }
}
