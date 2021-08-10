package nine;

class ConstructorTestThisParent
{
    public ConstructorTestThisParent()
    {
        System.out.println("Hello world parent :D");
    }
}


public class ConstructorTestThis extends ConstructorTestThisParent{

    public ConstructorTestThis()
    {
        //super(); //---> ERROR
        this("hello world");  // --> this MUST BE THE FIRST STATEMENT IN CONSTRUCTOR
        System.out.println("this :P");
    }

    public ConstructorTestThis(String ok)
    {
        System.out.println(ok);
    }

    public static void main(String[] args)
    {
        ConstructorTestThis c = new ConstructorTestThis();
    }
}
