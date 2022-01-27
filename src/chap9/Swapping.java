package chap9;

import java.awt.*;

/*
    Java passes arguments by CALL BY VALUE

    In case of Objects, the object reference is passed by value.

*/
public class Swapping
{
    public void badSwap(int var1, int var2)
    {
        System.out.println("var1 : "+var1);
        System.out.println("var2 : "+var2);
        int temp = var1;
        var1 = var2;
        var2 = temp;

        System.out.println("after swapping");
        System.out.println("var1 : "+var1);
        System.out.println("var2 : "+var2);
    }

    public static void tricky(Point arg1, Point arg2)
    {
        arg1.x = 100;
        arg1.y = 100;
        Point temp = arg1;
        arg1 = arg2;
        arg2 = temp;
    }

    /*
        pnt1 ,arg2 ,temp --> 1
        pnt2  , arg1 --> 1
    */

    public static void main(String [] args)
    {
        Point pnt1 = new Point(0,0);
        Point pnt2 = new Point(0,0);
        System.out.println("X: " + pnt1.x + " Y: " +pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
        System.out.println(" ");
        tricky(pnt1,pnt2);
        System.out.println("X: " + pnt1.x + " Y:" + pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
    }


   /* public static void main(String[] args)
    {
        Swapping sw = new Swapping();
        sw.badSwap(10,11);
    } */
}
