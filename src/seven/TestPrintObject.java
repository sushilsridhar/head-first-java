package seven;

public class TestPrintObject
{
    public static void main(String args[])
    {
        System.out.println(new Hello3());
    }
}
class Hello3
{
    public int hashCode(){
        return 10;
    }
}

