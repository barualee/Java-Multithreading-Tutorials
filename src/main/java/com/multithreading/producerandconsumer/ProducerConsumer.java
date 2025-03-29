package com.multithreading.producerandconsumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
    private static int sequence = 0;
    private static final Object lock = new Object();

    private List<Integer> stack;
    private int top;
    private int bottom;
    
    public ProducerConsumer(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
        this.stack = new ArrayList<>();
    }

    public void produce() throws InterruptedException{
        synchronized(lock){
            while(true){
                if(stack.size()==top){
                    System.out.println("Stack full, waiting for removal...");
                    lock.wait();
                } else {
                    System.out.println("Adding item to stack: "+sequence);
                    stack.add(sequence);
                    sequence++;
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException{
        synchronized(lock){
            while(true){
                if(stack.size()==bottom){
                    System.out.println("Stack empty, waiting for addition...");
                    lock.wait();
                } else {
                    System.out.println("Removing item from stack: "+stack.get(0));
                    stack.remove(0);
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

}
