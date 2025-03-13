package com.multithreading.synchronizedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedList {
    private List<Integer> li = new ArrayList<>();
    private List<Integer> lj = Collections.synchronizedList(new ArrayList<>());

    public void showDemo() throws InterruptedException{
        Thread t1 = new Thread(() -> {
            for(int i=0;i<100;i++){
                li.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0;i<100;i++){
                li.add(i);
            }
        });

        Thread t3 = new Thread(() -> {
            for(int i=0;i<100;i++){
                lj.add(i);
            }
        });

        Thread t4 = new Thread(() -> {
            for(int i=0;i<100;i++){
                lj.add(i);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("UnSync list: "+li.size());
        System.out.println("Sync List: "+lj.size());
    }
}
