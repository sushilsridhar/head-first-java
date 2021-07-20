package seven;

/*  TO STOP INHERITANCE
 *   - Make parent constructor private
 *   - Make Class final
 */

public class TestConstructor extends Parent
{
    TestConstructor()
    {
        System.out.println("Child Constructor");
    }

    public static void main(String []args)
    {
        System.out.println("Main method");
        TestConstructor ov = new TestConstructor();
        System.out.println(ov.name);
        // System.out.println(ov.number);

        // Parent p = new Parent();
    }
}

class Parent
{
   /* private Parent ()
    {
        System.out.println("Parent Constructor");
    }*/

    Parent ()
    {
        System.out.println("Parent Constructor");
    }

    String name="hello";
    private String number="1212";
}
