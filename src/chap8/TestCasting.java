package chap8;

/*
 *  OBJECT TYPE REFERENCE VARIABLE CAN BE CASTED TO TYPE OF THE ACTUAL OBJECT STORED IN HEAP
 */

public class TestCasting  {
    public static void main(String[] args)
    {

        TestCasting m = new TestCasting();

        System.out.println(m.getData(m));


        TestCasting m1 = (TestCasting) m.getData(m); // this will work as casting is done
    }

    public Object getData(Object o)
    {
        System.out.println("okai :P");
        return o;
    }
}
