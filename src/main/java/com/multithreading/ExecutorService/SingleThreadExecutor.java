package com.multithreading.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

    public void runSingleThreadExecutor() {
        //we put this in try with resources block, because we need to shut down the resources after completion.
        //one way to do this.
        try (ExecutorService exs = Executors.newSingleThreadExecutor()) {
            for (int i = 0; i < 5; i++) {
                exs.execute(new TaskWorker(i));
            }
        }
    }

}
