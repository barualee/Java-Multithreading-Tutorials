package com.multithreading.concurrentcollection.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<Integer> ex = new Exchanger<>();
        Thread one  = new Thread(new FirstThread(ex));
        Thread two  = new Thread(new SecondThread(ex));
    
        one.start();
        two.start();
    }
}

    class FirstThread implements Runnable{
        private final Exchanger<Integer> exchanger;

        public FirstThread(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            int dataToSend = 10;

            System.out.println("Data to sendby first thread: "+dataToSend);

            try {
                Integer recvdData = exchanger.exchange(dataToSend);
                System.out.println("First thread recvd: "+recvdData);
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }        
    }

    class SecondThread implements Runnable{
        private final Exchanger<Integer> exchanger;

        public SecondThread(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                int dataToSend = 20;
    
                System.out.println("Data to send by second thread: "+dataToSend);
                Integer recvdData = exchanger.exchange(dataToSend);
                System.out.println("Second thread recvd: "+recvdData);
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }        
    }

