package com.multithreading.callableinterface;

import java.util.concurrent.Callable;

public class WorkerDelayCallable implements Callable<Integer>{
    @Override
    public Integer call() throws Exception{
        Thread.sleep(5000);
        return 12;
    }
}
