package com.ocpexamples.threads;

public class CountThread implements Runnable {

    public void run() {
	System.out.println("Thread priority= " + Thread.currentThread().getPriority());
	for (int i = 0; i < 101; i++) {
	    if (i % 10 == 0) {
		System.out.println("CountThread running at number: " + i);
	    }

	    try {
		Thread.sleep(500);
	    } catch (InterruptedException e) {

		e.printStackTrace();
	    }
	}
    }

}