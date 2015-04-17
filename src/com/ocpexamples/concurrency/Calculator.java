package com.ocpexamples.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Calculator implements Runnable {

    private final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();
    private static int total;
    int number;

    public Calculator(final int number) {
	this.number = number;
    }

    @Override
    public void run() {
	System.out.println(Thread.currentThread().getName() + " is running...... ");
	System.out.println("Adding......");
	lock.lock();
	try {
	    for (int i = 0; i < number; i++) {
		total += i;
		System.out.print("["+i+"]= "+ total+" ");
	    }
	    System.out.println(" ");
	    condition.signalAll();

	} finally {
	    lock.unlock();
	}
    }

    public static int getTotal() {
	return total;
    }

}
