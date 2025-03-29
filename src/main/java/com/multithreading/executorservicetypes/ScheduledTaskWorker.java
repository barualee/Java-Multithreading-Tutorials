package com.multithreading.executorservicetypes;

public class ScheduledTaskWorker implements Runnable {

    @Override
    public void run(){
        System.out.println("Run by Thread: "+Thread.currentThread().getName());
    }
}
