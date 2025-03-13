package com.multithreading.synchronization;

public class WithoutSync {
    public static int counter=0;
   
    public void withoutSyncMethod(){
        Thread one = new Thread(() -> {
            for(int i=0;i<10000;i++){
                counter++;
            }
        });

        Thread two = new Thread(() -> {
            for(int i=0;i<10000;i++){
                counter++;
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

        System.out.println("Counter value without sync: "+counter);
    }
}
