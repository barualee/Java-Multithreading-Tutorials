package com.multithreading.extendthreadclass;

public class ThreadOne extends Thread{
    @Override
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println("One Thread extended: "+i);
        }
    }
}
