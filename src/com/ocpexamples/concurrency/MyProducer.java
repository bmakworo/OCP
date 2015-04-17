package com.ocpexamples.concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class MyProducer implements Runnable {

    private final BlockingQueue<Integer> queue;
    private Random random;

    public MyProducer(BlockingQueue<Integer> bq) {
	this.queue = bq;
	random= new Random();
    }

    @Override
    public void run() {

	while (true) {
	    int number = random.nextInt(10_000);
	    try {
		queue.put(number);
		Thread.sleep(700);
	    } catch (InterruptedException e) {

		e.printStackTrace();
	    }
	}

    }

}
