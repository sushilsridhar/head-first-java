package three;

/**
 *   Scope of local reference variable
 *
 */

public class TestObject
{
    int count =0;

    public static void main(String []args)
    {
        int x =0;
        while(x < 5)
        {
            TestObject ov = new TestObject();
            ov.method();
            System.out.println("after method "+ov.count);
            ov.count= ov.count +1;
            System.out.println(ov.count);
            x=x+1;
        }
        // System.out.println(ov.count);

    }

    int method() // scope of this is destroyed after method return
    {
        TestObject ov = new TestObject();
        ov.count= ov.count +1;
        System.out.println(" inside "+ov.count);
        return 0;
    }

}


