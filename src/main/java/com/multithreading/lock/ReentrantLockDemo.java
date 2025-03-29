package com.multithreading.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final ReentrantLock lock = new ReentrantLock();
    private int sharedData = 0;

    public void methodA() {
        lock.lock();
        try {
            //critical section
            sharedData++;

            System.out.println("Method A: Shareed Data: "+sharedData);
            methodB();

        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            //critical section
            sharedData --;
            System.out.println("Method B: Shareed Data: "+sharedData);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        for(int i=0;i<10;i++){
            new Thread(demo::methodA).start();
        }
    }
}
