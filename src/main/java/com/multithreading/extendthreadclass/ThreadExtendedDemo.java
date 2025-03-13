package com.multithreading.extendthreadclass;

public class ThreadExtendedDemo {

    public void showDemo(){
        Thread one = new ThreadOne();
        Thread two = new ThreadTwo();

        one.start();
        two.start();
    }
}
