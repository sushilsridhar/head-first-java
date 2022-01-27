package chap15;

public class FirstMultiThread {

    public static void main(String[] args)
    {
        Thread t = new Thread(new MyThread());
        t.start();
        System.out.println("main stack");
    }
}

class MyThread implements Runnable
{
    public void run()
    {
        go();
    }

    public void go()
    {
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        doMore();
    }

    public void doMore()
    {
        System.out.println("new Thread Stack");
    }
}
