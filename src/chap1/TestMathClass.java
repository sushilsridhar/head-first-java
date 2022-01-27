package chap1;

public class TestMathClass {
    public static void main(String []args)
    {
        //double a=989.45;
        //double b=900.01;

        double a = -100.675; // floor makes it 101.0 and ceil makes it 100.0
        float b = -90;

        System.out.println("floor:"+Math.floor(a));
        System.out.println("floor:"+Math.floor(b));

        System.out.println("ceil"+Math.ceil(a));
        System.out.println("ceil"+Math.ceil(b));
    }
}
