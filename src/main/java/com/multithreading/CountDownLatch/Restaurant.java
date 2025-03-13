package com.multithreading.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Restaurant implements Runnable{
    private String name;
    private String dish;
    private CountDownLatch latch;
    
    public Restaurant(String name, String dish, CountDownLatch latch) {
        this.name = name;
        this.dish = dish;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name+" is preparing "+dish);
            Thread.sleep(2000);
            System.out.println(name+" has finished preparing "+dish);
            latch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
    }
}
