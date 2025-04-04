package com.multithreading.concurrentcollection.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static final int NUM_TOURISTS = 5;
    private static final int NUM_STAGES = 3;
    private static final CyclicBarrier cb = new CyclicBarrier(NUM_TOURISTS, () -> {
        System.out.println("Guide starts speaking....");
    });

    public static void main(String[] args) {
        for(int i=0;i<NUM_TOURISTS;i++){
            Thread tH = new Thread(new Tourist(i));
            tH.start();
        }
    }

    static class Tourist implements Runnable{

        private final int touristId;
        
        public Tourist(int touristId) {
            this.touristId = touristId;
        }
        
        @Override
        public void run() {
            for(int i=0;i<NUM_STAGES;i++){
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
                System.out.println("Tourist "+touristId+" arrives at stage "+(i+1));

                try {
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e){
                    throw new RuntimeException(e);
                }
            }

        }
        
    }
}
