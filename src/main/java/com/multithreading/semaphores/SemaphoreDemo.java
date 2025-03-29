package com.multithreading.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        try (ExecutorService es = Executors.newCachedThreadPool()){
            for(int i=0;i<75;i++){
                es.execute(new Runnable() {
                    @Override
                    public void run() {
                        ScrapeService.INSTANCE.scrape();
                    }
                });
            }
        }
    }
}

enum ScrapeService{
    INSTANCE;

    private Semaphore sp = new Semaphore(3);

    public void scrape(){
        try {
            sp.acquire();
            invokeBot();
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        } finally {
            sp.release();
        }
    }

    private void invokeBot() {
        try {
            System.out.println("Scrapping...");
            Thread.sleep(2000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
