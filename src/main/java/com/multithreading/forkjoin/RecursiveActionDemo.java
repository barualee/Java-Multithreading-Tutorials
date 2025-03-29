package com.multithreading.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class RecursiveActionDemo extends RecursiveAction{

    private final long workload;

    public RecursiveActionDemo (long workload){
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if(workload>16){
            System.out.println("Splitting... "+workload);
            long firstHalf = workload/2;
            long secondHalf = workload - firstHalf;

            RecursiveAction first = new RecursiveActionDemo(firstHalf);
            RecursiveAction second = new RecursiveActionDemo(secondHalf);

            first.fork();
            second.fork();
        } else {
            System.out.println("Within limits! workload executed: "+workload);
        }
    }
}

class demov{
    public static void main(String[] args) {
        try(ForkJoinPool fJPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors())){
            RecursiveActionDemo demo = new RecursiveActionDemo(1024);
            fJPool.invoke(demo);
        }
    }
}
