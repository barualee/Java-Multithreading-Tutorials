package com.multithreading.executorservicetypes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CPUIntensiveTaskDemo {
    
    public void showDemo(){
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Cores available: "+cores);

        try (ExecutorService exs = Executors.newFixedThreadPool(cores)) {
            for (int i = 0; i < 10; i++) {
                exs.execute(new TaskWorker(i));
            }
        }
    }
}
