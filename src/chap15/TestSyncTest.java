package chap15;

class TestSync implements Runnable {
    private int balance;

    public void run() {

        for(int i=0; i<50; i++) {
            increment();
            System.out.println("balance is :"+ balance);
        }
    }

    public void increment() {
        int i = balance;
        balance = i + 1;
    }

}


class TestSyncTest {
    public static void main(String[] args) {

        TestSync job = new TestSync();

        Thread threadOne = new Thread(job);
        Thread threadTwo = new Thread(job);

        threadOne.start();
        threadTwo.start();
    }
}
