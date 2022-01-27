package chap8;

/*
 *      - Abstract keyword restricts the user of new keyword
 *      - Abstract class can contain only non-abstract methods also
 *
 *       TestAbstractHelper t = new TestAbstract(); // WORKS
 */
abstract class TestAbstractHelper {

    public TestAbstractHelper()
    {
        System.out.println("TestAbstractHelper constructor");
    }

    //abstract public void getData(); // WORKS WHEN COMMENTED ALSO

    public void show()
    {
        System.out.println("Non Abstract method");
    }
}

public class TestAbstract extends TestAbstractHelper
{
    public TestAbstract()
    {
        System.out.println("TestAbstract constructor");
    }

    public static void main(String[] args)
    {
        //TestAbstractHelper t = new TestAbstract(); // WORKS
        TestAbstractHelper t = new TestAbstract();

        //t.getData();
        t.show();
    }

    public void getData()
    {
        System.out.println("okai :P");
    }
}
