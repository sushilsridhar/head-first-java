package chap5;

public class TestCasting {

    public static void main(String[] args)
    {
        long y = 40002;
        short x = (short) y;

        //short z = 33534; //error -> limit of short is 32,767

        System.out.println(x);
    }
}

