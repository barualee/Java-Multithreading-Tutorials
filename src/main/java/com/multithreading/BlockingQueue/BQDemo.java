package com.multithreading.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BQDemo {
    static final int size = 20;
    static BlockingQueue<Integer> q = new ArrayBlockingQueue<>(size);
    
    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                for(int i=0;i<20;i++){
                    q.put(i);
                    System.out.println("Task added: "+i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer1 = new Thread(() -> {
            try {
                while(true){
                    int i = q.take();
                    processTask(i, "ProcessOne");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                while(true){
                    int i = q.take();
                    processTask(i, "ProcessTwo");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer1.start();
        consumer2.start();
    }

    private static void processTask(int taskId, String con) throws InterruptedException{
        System.out.println("Processing task: "+taskId+" by: "+con);
        Thread.sleep(2000);
        System.out.println("Consumed task: "+taskId+" by: "+con);
    }
}
