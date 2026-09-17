package com.meridianbank.threads;

/**
 * Simulates dispatching a notification to a bank customer on its own thread.
 */
public class NotificationDispatcher implements Runnable {

    private final String accountId;
    private final String message;

    public NotificationDispatcher(String accountId, String message) {
        this.accountId = accountId;
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " | Dispatching to " + accountId);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " | Sent: " + message);
    }
}