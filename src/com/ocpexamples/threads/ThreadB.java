package com.ocpexamples.threads;

public class ThreadB extends Thread {

    private int total;
    private int numbersToAdd;

    public ThreadB(int numbers) {
	this.numbersToAdd = numbers;
    }

    public void run() {
	synchronized (this) {
	    for (int i = 0; i < numbersToAdd; i++) {
		total += i;
	    }
	    notify();
	}
    }

    public int getTotal() {
	return total;
    }
}
