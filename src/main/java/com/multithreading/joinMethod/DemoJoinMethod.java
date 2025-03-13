package com.multithreading.joinMethod;

import com.multithreading.extendthreadclass.ThreadOne;
import com.multithreading.extendthreadclass.ThreadTwo;

public class DemoJoinMethod {
    public void showDemo() throws InterruptedException{
        Thread one = new ThreadOne();
        Thread two = new ThreadTwo();

        System.out.println("Before start");

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println("After threads complete");
    }
}
