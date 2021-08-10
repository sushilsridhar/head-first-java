package ten;

public class Legal
{
    final static int x = 10;

    public void go(final int x)
    {
        System.out.println(x);
        System.out.println(Legal.x);
    }

    public static void main(String[] args)
    {
        int x = 11;
        Legal g = new Legal();
        g.go(x);
    }
}
