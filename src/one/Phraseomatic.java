package one;

public class Phraseomatic {
    public static void main (String[] args)
    {
        String[] wordListOne ={"24/7","multiTiar","30,OOO foot", "B-to-B" , "win-win" , "frontend"
                , "web- based" , "pervasive", "smart", "sixsigma",
                "cri tical-path" , "dynamic"};

        String[] wordListTwo ={"empowered", "sticky",
                "value-added.", "oriented", "centric", "distributed",
                "clustered", "branded", "outaide-the-box", "positioned",
                "networked", " f ocused" , "leveraged", "aligned",
                "targeted", "shared" , "cooperative", "accelerated"};

        int oneLength= wordListOne.length;
        int twoLength= wordListTwo.length;

        int randl =(int) (Math.random() * oneLength);
        int rand2 =(int) (Math.random() * twoLength);

        System.out.println(Math.random());

        //now build a pllrue
        String phrase= wordListOne[randl] + " " + wordListTwo[rand2];

        // print oat the phra..
        System.out.println("What we need is a " + phrase);
    }
}
