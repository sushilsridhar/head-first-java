package chap5;

public class TestPrePost
{
    public static void main(String[] args)
    {
        int a=5,i;

        i = ++a + ++a + a++;
        //  6 + 7 + 7 (a = 8)

        i = a++ + ++a + ++a;
        // 8 + 10 + 11 (a = 11)

        a = ++a + ++a + a++;
        // resolve variables first
        // 12 + 13 + 13 (a = 14)
        // assign 14 to a
        // a = 12 + 13 + 13
        // a = 38  // overidden old a value

        System.out.println(a); //38
        System.out.println(i); //29

        /*
           ++a
           ----> a = a + 1;
           ----> return a;

           a++
           ----> temp = a;
           ----> a = a + 1;
           ----> return temp;
         */
    }
}
