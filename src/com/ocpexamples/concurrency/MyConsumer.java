package com.ocpexamples.concurrency;

import java.util.concurrent.BlockingQueue;

public class MyConsumer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public MyConsumer(BlockingQueue<Integer> q) {
	this.queue = q;
    }

    @Override
    public void run() {
	while (true) {
	    try {
		System.out.print(queue.take() + "  ");
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }
}
