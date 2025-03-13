package com.multithreading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public void runFixedThreadExecutor() {
        try (ExecutorService exs = Executors.newFixedThreadPool(10)) {
            for (int i = 0; i < 50; i++) {
                exs.execute(new TaskWorker(i));
            }
        }
    }
}
