package com.multithreading.extendthreadclass;

public class ThreadTwo extends Thread {
    @Override
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println("Two Thread extended: "+i);
        }
    }
}
