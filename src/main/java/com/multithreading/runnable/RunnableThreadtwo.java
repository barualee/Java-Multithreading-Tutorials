package com.multithreading.runnable;

public class RunnableThreadtwo implements Runnable {
    
    @Override
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println("Two Thread: "+i);
        }
    }
}
