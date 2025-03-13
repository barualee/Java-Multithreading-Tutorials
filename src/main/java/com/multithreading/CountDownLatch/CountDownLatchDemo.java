package com.multithreading.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int chefs = 3;
        CountDownLatch cdl = new CountDownLatch(chefs);

        new Thread(new Restaurant("Chef A", "Salad", cdl)).start();
        new Thread(new Restaurant("Chef B", "Pizza", cdl)).start();
        new Thread(new Restaurant("Chef C", "Chicken", cdl)).start();

        cdl.await();
        System.out.println("All dishes ready!");
    }
}
