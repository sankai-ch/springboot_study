package com.example;

/**
 * @author sankai
 * @since 2019-12-20
 */
public class Disapper implements Runnable {

    static Disapper instance = new Disapper();

    static int i = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
