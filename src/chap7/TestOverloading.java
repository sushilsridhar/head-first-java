package chap7;

public class TestOverloading
{
    public void show(String a,int b)
    {
        System.out.println(a+" "+b);
    }

    public void show(int a,String b)
    {
        System.out.println(a+" "+b);
    }

    public static void main(String[] args)
    {
        TestOverloading tam = new TestOverloading();
        tam.show("hello",1);
        tam.show(2,"world");
    }
}
