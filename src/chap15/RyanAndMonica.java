package chap15;

class RyanAndMonica implements Runnable {

    RMBankAccount rmBankAccount = new RMBankAccount();

    public static void main(String[] args)
    {
        RyanAndMonica job = new RyanAndMonica();

        Thread ryanThread = new Thread(job);
        ryanThread.setName("Ryan Thread");

        Thread monicaThread = new Thread(job);
        monicaThread.setName("Monica Thread");

        ryanThread.start();
        monicaThread.start();
    }

    public void run() {
        for(int i =0; i<10; i++)
        {
            makeWithDrawl(10);
            if(rmBankAccount.getBalance() < 0)
            {
                System.out.println("over drawn! ");
            }
        }
    }

    private synchronized void makeWithDrawl(int amount)
    {
        if(rmBankAccount.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() +"is about to with draw");
            try {
                System.out.println(Thread.currentThread().getName() +"is about to sleep");
                Thread.sleep(500);
            }
            catch(InterruptedException e) {};
            System.out.println(Thread.currentThread().getName() +" woke up");
            rmBankAccount.withDraw(amount);
            System.out.println(Thread.currentThread().getName() +" completes with draw");
        }
        else
        {
            System.out.println("sorry! not enough for "+Thread.currentThread().getName());
        }
    }
}

class RMBankAccount {

    int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withDraw(int amount)
    {
        balance = balance - amount;
    }
}

