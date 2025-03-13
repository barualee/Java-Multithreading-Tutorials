package com.multithreading.ExecutorService;

public class TaskWorker implements Runnable{

    private final int taskId;

    public TaskWorker(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run(){
        System.out.println("TaskId: "+taskId+ " Run by Thread: "+Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
