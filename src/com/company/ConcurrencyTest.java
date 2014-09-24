package com.company;

import java.util.ArrayList;

/**
 * Created by wes on 9/24/14.
 */
public class ConcurrencyTest {
    public static ArrayList<Integer> queue = new ArrayList<Integer>();

    public synchronized void addToQueue(Integer i) {
        queue.add(i);
    }

    public synchronized Integer pullFromQueue() {
        if (queue.size() > 0) {
            return queue.remove(0);
        } else {
            return -1;
        }
    }

    public class Producer implements Runnable {

        private final static int NUM_MESSAGES = 10;

        private void pushIntoQueue() throws InterruptedException {
            int randInt = Util.randInt(0,1000);

            System.out.println("pushIntoQueue: "+randInt);
            addToQueue(randInt);

            Thread.sleep(1000);
        }

        @Override
        public void run() {
            try {
                System.out.println("Producer running! Sleeping first...");
                Thread.sleep(1000);

                for(int n=0;n<NUM_MESSAGES;n++) {
                    pushIntoQueue();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class Consumer implements Runnable {

        private Integer readFromQueue() throws InterruptedException {
            return pullFromQueue();
        }

        @Override
        public void run() {
            try {
                System.out.println("Consumer running! Sleeping first...");
                Thread.sleep(1000);

                while(true) {
                    int item = readFromQueue();
                    System.out.println("Read "+item+" from queue");

                    if(item < 0) {
                        return;
                    } else {
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ConcurrencyTest(int numProducers, int numConsumers) {
        ArrayList<Thread> producers = new ArrayList<Thread>();
        for(int p=0;p<numProducers;p++) {
            Thread thread = new Thread(new Producer());
            producers.add(thread);
            thread.start();
        }

        ArrayList<Thread> consumers = new ArrayList<Thread>();
        for(int p=0;p<numConsumers;p++) {
            Thread thread = new Thread(new Consumer());
            consumers.add(thread);
            thread.start();
        }
    }
}
