package com.ocpexamples.threads;

public class FooRunnable implements Runnable {

    @Override
    public void run() {
	for (int i = 0; i < 10; i++) {
	    // System.out.println("Runnable running");
	    System.out.println("Runnable run by: " + Thread.currentThread().getName() + " , X is: " + i);
	    try {
		Thread.sleep(10);
	    } catch (InterruptedException e) {

		e.printStackTrace();
	    }

	}
    }

}
