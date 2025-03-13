package com.multithreading.daemonthread;

public class DaemonThreadDemo {

    public void showDemo(){
        Thread one = new Thread(() -> {
            while(true){
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
                System.out.println("Daemon thread running");

            }
        });

        Thread two = new Thread(() -> {
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("User thread running completed!");
        });

        one.setDaemon(true);
        
        one.start();
        two.start();
    }
}
