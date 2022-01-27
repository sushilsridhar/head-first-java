package chap15;

class RunThreads implements Runnable {

    public static void main(String[] args) {

        RunThreads job = new RunThreads();
        Thread alphaThread = new Thread(job);
        Thread betaThread = new Thread(job);
        alphaThread.setName("Alpha Thread");
        betaThread.setName("Beta Thread");
        alphaThread.start();
        betaThread.start();
    }

    public void run() {
        for(int i=0; i<=25; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName +" is running");
        }
    }
}
