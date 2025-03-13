package com.multithreading.sequential;

public class sequentialDemo {
    public void showSequential(){
        demo1();
        demo2();
    }

    public void demo1(){
        for(int i=0;i<5;i++){
            System.out.println("From demo1: "+i);
        }
    }

    public void demo2(){
        for(int i=0;i<5;i++){
            System.out.println("From demo2: "+i);
        }
    }
}
