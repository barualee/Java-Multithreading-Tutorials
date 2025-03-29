package com.multithreading.producerandconsumer;

public class Demo {
    public void demoProduceConsume(){
        ProducerConsumer pc = new ProducerConsumer(5, 0);

        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();;
        t2.start();
        
    }
}
