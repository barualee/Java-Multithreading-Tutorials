package com.multithreading.synchronization;

//decoupled concerns for the two threads
public class CustomLockObject {
    public static int counter=0;
    public static int counter2=0;

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public void customLockDemo(){
        Thread one = new Thread(() -> {
            for(int i=0;i<10000;i++){
                increment1();
            }
        });

        Thread two = new Thread(() -> {
            for(int i=0;i<10000;i++){
                increment2();
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

        System.out.println("Counter value with custom lock: "+counter);
        System.out.println("Counter2 value with custom lock: "+counter2);
    }

    private static void increment1(){
        synchronized(lock1){
            counter++;
        }
    }

    private static void increment2(){
        synchronized(lock2){
            counter2++;
        }
    }

}
