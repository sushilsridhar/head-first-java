package chap1;

/**
 println - ADDS NEW LINE AFTER PRINTING

 OUTPUT

 Test10.8 :10

 */

public class TestPrint  // class name can in lowercase also
{
    public static void main(String []args)
    {
        float a=10.8f;   // f mandatory else considered as DOUBLE
        int b=(int)a;
        //System.out.print("Test");
        System.out.println(a+" :"+b);
    }
}
