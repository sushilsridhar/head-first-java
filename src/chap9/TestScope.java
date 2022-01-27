package chap9;


import sun.jvm.hotspot.HelloWorld;

public class TestScope {

    HelloWorld hello = new HelloWorld();

    public void show()
    {
        System.out.println(hello);
        hello = null;
        System.out.println(hello);

    }

    public static void main(String[] args)
    {
        TestScope t = new TestScope();
        t.show();
        TestScope t1 = new TestScope();
        t1.show();
    }
}

/*
    testscope.HelloWorld@15db9742
    null
    testscope.HelloWorld@6d06d69c
    null
*/

/*

gc1 --> 1
gc2 --> 1
gc3, gc4 --> 1

honeypot , ha[4] --> 1
b1 --> 1
*/



