package chap8;

/*
 *   Accessing static method using reference variable --> WILL WORK BUT SHOULDN'T BE DONE
 */

class TestStaticHelper
{
    public static void show()
    {
        System.out.println("Hello World show :D");
    }

    public static void main(String[] args)
    {

        System.out.println("Hello World :D");

    }

}

public class TestStaticMain
{
    public static void main(String[] args)
    {
        String s[] ={};

        TestStaticHelper c = new TestStaticHelper();
        c.main(s);
        c.show();

    }
}
