package com.multithreading.forkjoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskDemo extends RecursiveTask<Integer>{

    int[] arr;
    int start;
    int end;
    int searchEl;

    public RecursiveTaskDemo(int[] arr, int start, int end, int searchEl) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.searchEl = searchEl;
    }

    @Override
    protected Integer compute() {
        return search();
    }

    private Integer search() {
        int count=0;
        for(int i=start;i<=end;i++){
            if(arr[i]==searchEl)count++;
        }
        return count;
    }
}

class demo{
    public static void main(String[] args) {
        int[] ar = new int[100];
        Random rnd = new Random();

        for(int i=0;i<100; i++){
            ar[i] = rnd.nextInt(10)+i;
        }

        int searchEl = (rnd.nextInt(10)+1)*10 + rnd.nextInt(10)+1;

        try(ForkJoinPool fJPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors())){
            RecursiveTaskDemo demo = new RecursiveTaskDemo(ar, 0, ar.length-1, searchEl);
            Integer res = fJPool.invoke(demo);
            System.out.println("Array is: "+Arrays.toString(ar));
            System.out.println("The number "+searchEl+" is found "+res+" times in the array");
        }
    }
}
