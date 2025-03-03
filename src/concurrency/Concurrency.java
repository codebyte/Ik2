package concurrency;

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside Run ....");
        go();
    }

    public void go() {
        System.out.println("Inside Go ....");
        more();
    }

    public void more() {
        System.out.println("Inside More ....");
    }
}

class DataAggregator implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Data Aggregator");
        }
    }
}

class EmailPriority implements Runnable {
    int i = 0;
    private Object key = new Object();


    @Override
    public void run() {
        increment();
    }

    public void increment() {
        synchronized (key) {
            for (int j = 0; j < 1000000000; j++)
                this.i += 1;
        }
    }

    public void print() {
        System.out.println(i);
    }

}


public class Concurrency {

    public static void main(String args[]) throws InterruptedException {

        EmailPriority email = new EmailPriority();

        Thread[] th = new Thread[10];
        for (int i = 0; i < 10; i++) {
            th[i] = new Thread(email);
            th[i].start();
        }

        for (int i = 0; i < 10; i++) {
            th[i].join();
        }

        email.print();
    }
}
