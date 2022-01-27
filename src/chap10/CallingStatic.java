package chap10;

/*
 *   Accessing static method using reference variable --> WILL WORK BUT SHOULDN'T BE DONE
 *
 *   All Static variables in a class initialised before any object of the class can be created
 *   Static variables in class are initialised before any static method of the class runs
 */

class CallingStaticHelper
{
    public static void main(String[] args)
    {
        System.out.println("Hello world :D");
    }

    public static void display()
    {
        System.out.println("Hello world :D from display");
    }
}

public class CallingStatic
{
    public static void main(String[] args)
    {
        CallingStaticHelper csh = new CallingStaticHelper();

        String s[] = {};
        csh.main(s);

        csh.display();

        CallingStaticHelper.display();
    }
}
