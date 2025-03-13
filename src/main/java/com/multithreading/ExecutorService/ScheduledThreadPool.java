package com.multithreading.ExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
    
    public void showDemo(){
        
        ScheduledExecutorService es = Executors.newScheduledThreadPool(5);
        es.scheduleAtFixedRate(new ScheduledTaskWorker(), 1000, 2000, TimeUnit.MILLISECONDS);

        try{
            if(!es.awaitTermination(18000, TimeUnit.MILLISECONDS)){
                es.shutdownNow();
            } 
        } catch (InterruptedException e){
            es.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
