package com.multithreading.executorservicetypes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    
    public void runCachedThreadExecutor() {
        try (ExecutorService exs = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 50; i++) {
                exs.execute(new TaskWorker(i));
            }
        }
    }
}
