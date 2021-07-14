package seven;

/*
 *   private variable can't be inherited
 */

class TestPrivateParent
{
    String name="hello";
    private String number="1212";
}

public class TestPrivate extends TestPrivateParent
{

    public static void main(String []args)
    {
        TestPrivate ov = new TestPrivate();
        System.out.println(ov.name);
        //System.out.println(ov.number);
    }
}


