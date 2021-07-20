package eight;

/*
 *       USING instanceof TO CHECK BEFORE CASTING
 */

public class TestCasting2  {
    public static void main(String[] args)
    {

        TestCasting2 m = new TestCasting2();

        System.out.println(m.getData(m));


        Object m1 =  m.getData(m);

        if(m1 instanceof TestCasting2)
        {
            System.out.println("CAN BE CASTED :D");
            TestCasting2 m2 = (TestCasting2) m1;
        }
    }

    public Object getData(Object o)
    {
        System.out.println("okai :P");
        return o;
    }
}
