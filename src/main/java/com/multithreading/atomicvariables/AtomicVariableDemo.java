package com.multithreading.atomicvariables;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableDemo {
    private static Integer nonAtomic = 0;
    private static final AtomicInteger atomic = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i=0;i<1000;i++){
                nonAtomic++;
                atomic.getAndIncrement();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0;i<1000;i++){
                nonAtomic++;
                atomic.getAndIncrement();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        System.out.println("Normal Variable: "+nonAtomic);
        System.out.println("Atomic: "+atomic);
    }
}
