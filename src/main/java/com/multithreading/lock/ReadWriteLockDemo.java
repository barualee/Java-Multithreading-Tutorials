package com.multithreading.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        SharedResource sr = new SharedResource();

        for(int i=0;i<2;i++){
            Thread reader = new Thread(() -> {
                for(int j=0;j<3;j++){
                    sr.getValue();
                }
            });
            reader.setName("Reader Thread: "+(i+1));
            reader.start();
        }

        Thread writer = new Thread(() -> {
            for(int j=0;j<5;j++){
                sr.increment();
            }
        });
        writer.setName("Writer Thread: ");
        writer.start();
    }
}

class SharedResource {
    private int counter = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void increment(){
        lock.writeLock().lock();

        try{
            counter++;
            System.out.println(Thread.currentThread().getName()+" writes: "+counter);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void getValue(){
        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+" read: "+counter);
        } finally {
            lock.readLock().unlock();
        }
    }


}
