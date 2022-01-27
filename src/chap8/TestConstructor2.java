package chap8;

/*
 *   You can have two constructors that have identical types, as long as the order is different.
 *   A constructor that takes a String followed by an int, is not
 *   the same as one that takes an int followed by a String.
 */

public class TestConstructor2 {

    public TestConstructor2() {}

    public TestConstructor2(int a,String b)
    {
        System.out.println("no-arg TestConstructor2");
    }

    public TestConstructor2(String a,int b)
    {
        System.out.println("no-arg TestConstructor2");
    }

    public static void main(String[] args)
    {
        TestConstructor2 c = new TestConstructor2(); // compiler won't generate the default constructor

        TestConstructor2 c1 = new TestConstructor2(10,"hello");
        TestConstructor2 c2 = new TestConstructor2("hello",10);
    }
}
