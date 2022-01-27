package chap12;

public class OuterClass {

    private int x;

    InnerClass inner = new InnerClass();

    public void doStuff()
    {
        inner.go();
    }


    class InnerClass {

        void go()
        {
            x=42;
            System.out.println(x);
        }
    }

    public static void main(String []args)
    {
        OuterClass o = new OuterClass();
        o.doStuff();
    }
}
