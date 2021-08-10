package nine;

class ConstructorMethodHelper
{
    public ConstructorMethodHelper(int a)
    {
        System.out.println("inside constructor");
        a=a+1;
        hello(a);
    }

    public void hello(int a)
    {
        System.out.println("calling from constructor: "+ a);

    }

}

public class ConstructorMethod
{
    public static void main(String[] args)
    {
        int a= 10;
        ConstructorMethodHelper cm = new ConstructorMethodHelper(a);

        System.out.println(a);
    }
}