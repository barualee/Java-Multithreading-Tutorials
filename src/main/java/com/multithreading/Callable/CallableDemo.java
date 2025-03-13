package com.multithreading.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableDemo {
    
    public void callableDemoSimple() throws InterruptedException, ExecutionException{
        try(ExecutorService es = Executors.newFixedThreadPool(3)){
            Future<Integer> res = es.submit(new WorkerCallable());
            System.out.println(res.get());
            System.out.println("Main thread execution completed...");
        }
    }

    public void callableDemoDelayed() throws InterruptedException, ExecutionException{
        try(ExecutorService es = Executors.newFixedThreadPool(3)){
            Future<Integer> res = es.submit(new WorkerDelayCallable());

            //if this is true, then future maybe cancelled, if false cant be cancelled.
            res.cancel(true);
            //here, give info if future got cancelled, can be used to create business logic based on answer got.
            // boolean cancelled = res.isCancelled();
            //return true whether future completed or got cancelled.
            // boolean isDone = res.isDone();

            System.out.println(res.get());
            System.out.println("Main thread execution completed...");
        }
    }
    //this is because the thread get method has delay timer of 3 seconds < delay(5sec) and then terminate w/o getting the future returned
    //if this time is greater then it would execute normally
    public void callableDemoDelayExceptionThrown() throws InterruptedException, ExecutionException, TimeoutException{
        try(ExecutorService es = Executors.newFixedThreadPool(3)){
            Future<Integer> res = es.submit(new WorkerDelayCallable());
            System.out.println(res.get(3, TimeUnit.SECONDS));
            System.out.println("Main thread execution completed...");
        }
    }
}
