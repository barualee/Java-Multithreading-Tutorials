package com.multithreading.synchronization;

public class SynchronizationMethod {
    
    public static int counter=0;

    public void withSyncMethod(){
        Thread one = new Thread(() -> {
            for(int i=0;i<10000;i++){
                increment();
            }
        });

        Thread two = new Thread(() -> {
            for(int i=0;i<10000;i++){
                increment();
            }
        });
        
        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value with sync: "+counter);
    }

    private synchronized static void increment(){
        counter++;
    }
}
