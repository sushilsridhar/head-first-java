package five;


public class TestEquals {

    public static void main(String[] args)
    {
        int a = 1;
        String b = new String("1");

        String c = "1";
        String d = "1";

        GameHelper g = new GameHelper();
        GameHelper g1 = new GameHelper();

        if(c == d)
        {
            System.out.println("Hello java : D");
        }
        if(b == c)
        {
            System.out.println("Hello java :O");
        }

        if(b.equals(c))
        {
            System.out.println("Hello java : P");
        }
    }
}
