package seven;

/*
 *     CHECK FOLDER FOUR - POLYMORPHISM
 *     ALWAYS INVOKE METHODS FROM LAST SUBCLASS IN HIERARCHERY
 */

class A
{
    void m3()
    {
        System.out.println("A's m3, ");
    }
}

class B extends A
{
    void m3()
    {
        System.out.println("B's m3, ");
    }
}

class C extends B
{
    void m3()
    {
        System.out.println("C's m3, ");
    }

    void cSpecficMethod()
    {
        System.out.println("C Specific, ");
    }
}

public class MixedMessages
{
    public static void main(String[] args)
    {
        A a2 = new C(); // CALLS ONLY SUBCLASS METHODS IF OVERRIDEN , CAN'T INVOKE SUBCLASS SPECIFIC METHODS
        a2.m3();
        // a2.cSpecficMethod(); //ERROR - CAN'T INVOKE SUBCLASS SPECIFIC METHODS
    }
}
