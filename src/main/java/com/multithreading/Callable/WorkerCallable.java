package com.multithreading.Callable;

import java.util.concurrent.Callable;

public class WorkerCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception{
        return 12;
    }
}
