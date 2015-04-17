package com.ocpexamples.threads;

public class Calculator implements Runnable {

    private int total;
    int number;

    public Calculator(final int number) {
	this.number = number;
    }

    @Override
    public void run() {
	System.out.println(Thread.currentThread().getName() + " is running...... ");
	synchronized (this) {
	    for (int i = 0; i < number; i++) {
		total += i;
		System.out.print("is adding...... "+i+" ");
	    }
	    System.out.println(" ");
	    notifyAll();
	}
	
    }

    public int getTotal() {
	return total;
    }

}
