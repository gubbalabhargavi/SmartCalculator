package com.meridianbank.threads;

/**
 * Demonstrates dispatching notifications to three accounts concurrently,
 * each on its own thread, waiting for all three to finish before continuing.
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new NotificationDispatcher("ACC001", "Payment of Rs.5000 received"), "Dispatcher-1");
        Thread t2 = new Thread(new NotificationDispatcher("ACC002", "Payment of Rs.2500 received"), "Dispatcher-2");
        Thread t3 = new Thread(new NotificationDispatcher("ACC003", "Payment of Rs.10000 received"), "Dispatcher-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All notifications dispatched.");
    }
}