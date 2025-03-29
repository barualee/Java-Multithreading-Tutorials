package com.multithreading.deadlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo {
    private final Lock lockA = new ReentrantLock(true);
    private final Lock lockB = new ReentrantLock(true);

    public void workerOne(){
        lockA.lock();
        System.out.println("Worker One acquired Lock A");
        try{
            Thread.sleep(200);
        } catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }

        lockB.lock();
        System.out.println("Worker One acquired LockB");
        lockA.unlock();
        lockB.unlock();
    }

    public void workerTwo(){
        lockB.lock();
        System.out.println("Worker Two acquired Lock B");
        try{
            Thread.sleep(200);
        } catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }

        lockA.lock();
        System.out.println("Worker Two acquired Lock A");
        lockB.unlock();
        lockA.unlock();
    }

    public static void main(String[] args) {
        DeadLockDemo dm = new DeadLockDemo();
        new Thread(dm::workerOne).start();
        new Thread(dm::workerTwo).start();
    }
}
