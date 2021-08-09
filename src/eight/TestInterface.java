package eight;

/*
 *       POLYMORPHIC ARGUMENTS USING INTERFACE
 *
 *       You can call a method on an object only if the class of the reference variable has that method.
 */

interface TestInterfaceA
{
    void show();
}

class TestInterfaceB implements TestInterfaceA
{
    public void show()
    {
        System.out.println("okai :P");
    }
}

public class TestInterface
{
    public static void main(String[] args)
    {
        TestInterface c = new TestInterface();
        TestInterfaceB bb = new TestInterfaceB();
        c.test(bb);
    }

    public TestInterfaceA test(TestInterfaceA aaa)       // POLYMORPHIC ARGUMENTS USING INTERFACE
    {
        TestInterfaceB bbb = new TestInterfaceB();
        System.out.println(aaa);                       // PRINTS TestInterfaceB@7852e922
        return bbb;
    }
}
