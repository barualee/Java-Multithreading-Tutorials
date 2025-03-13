package com.multithreading.waitNnotify;

public class WaitnNotifyDemo {

    public static final Object lock = new Object();

    public void waitNnotifyWithLocks(){
        Thread one = new Thread(() -> {
            try {
                oneTask();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread two = new Thread(() -> {
            try {
                twoTask();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        
        one.start();
        two.start();
    }

    private static void oneTask() throws InterruptedException{
        synchronized(lock){
            System.out.println("From task 1...");
            lock.wait();
            System.out.println("Back to task 1..");
        }
    }

    private static void twoTask() throws InterruptedException{
        synchronized(lock){
            System.out.println("From task 2...");
            lock.notify();
            System.out.println("Even after notifying....");
        }
    }

}

