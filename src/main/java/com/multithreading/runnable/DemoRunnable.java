package com.multithreading.runnable;

public class DemoRunnable {
    public void demoRun(){
        Thread one = new Thread(new RunnableThreadOne());
        Thread two = new Thread(new RunnableThreadtwo());

        //using lambda
        Thread three = new Thread(() -> {
            for(int i=0;i<100;i++){
                System.out.println("Three Thread: "+i);
            }
        });
    
        one.start();
        two.start();
        three.start();
    }
}
