package chap8;

/*
 *   compiler won't generate the default constructor if parameterized constructor is used
 */

public class TestConstructor {

    public TestConstructor(int a)
    {
        System.out.println("no-arg C");
    }

    public static void main(String[] args)
    {
        //TestConstructor c = new TestConstructor(); // compiler won't generate the default constructor
    }
}
