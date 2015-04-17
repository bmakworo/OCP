package com.ocpexamples.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class BlockingQueueExample {

    public BlockingQueueExample() {}

    public static void main(String[] args) {
	BlockingQueue<Integer> bq= new ArrayBlockingQueue<>(1);
	MyProducer producer= new MyProducer(bq);
	MyConsumer consumer = new MyConsumer(bq);
	
	new Thread(producer).start();
	new Thread(consumer).start();
//	new Thread(c2).start();

    }

}
