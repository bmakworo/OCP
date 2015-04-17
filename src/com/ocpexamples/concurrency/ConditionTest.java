package com.ocpexamples.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest extends Thread {

    Calculator calc;
//    int total;
    
    private final Lock lock = new ReentrantLock();
    final Condition condition= lock.newCondition();

    public ConditionTest(Calculator c, String name) {
	super(name);
	calc = c;
    }
    
    public ConditionTest( String name) {
	super(name);
    }

    public void run() {
	

	String threadName = Thread.currentThread().getName();

//	if (threadName.equals("Thread-A")) {
//	    System.out.println(threadName + "...............");
//	    lock.lock();
//
//	} else if (threadName.equals("Thread-B")) {
//	    lock.tryLock();
//
//	} else if (threadName.equals("Thread-C")) {
//	    try {
//		lock.tryLock(3, TimeUnit.MILLISECONDS);
//	    } catch (InterruptedException e) {
//		e.printStackTrace();
//	    }
//
//	} else if (threadName.equals("Thread-D")) {
//	    try {
//		lock.lockInterruptibly();
//	    } catch (InterruptedException e) {
//		e.printStackTrace();
//	    }
//	}

//	calc.lock.Lock();
	
	lock.lock();
	
	System.out.println("lock= "+lock.toString());
	
	try {
	    System.out.println(Thread.currentThread().getName() + " Waiting for calculation ........");
//	    addValues(6);
	    condition.await();

	} catch (InterruptedException e) {
	    e.printStackTrace();
	} finally {
	    lock.unlock();
	}

	System.out.println("Running thread is: " + Thread.currentThread().getName() + " Total is: " + calc.getTotal());

    }
    
    
//    public void addValues(int number) {
//	
// 	System.out.println(Thread.currentThread().getName() + " is running...... ");
// 	System.out.println("Adding......");
// 	lock.lock();
// 	try {
// 	    for (int i = 0; i < number; i++) {
// 		total += i;
// 		System.out.print("["+i+"]= "+ total+" ");
// 	    }
// 	    System.out.println(" ");
// 	    condition.signalAll();
//
// 	} finally {
// 	    lock.unlock();
// 	}
//     }

    public static void main(String[] args) {

	Calculator calculator = new Calculator(6);
	new ConditionTest(calculator, "Thread-A").start();// lock
	new ConditionTest(calculator, "Thread-B").start();// tryLock
	new ConditionTest(calculator, "Thread-C").start();// tryLock(Time)
	new ConditionTest(calculator, "Thread-D").start();// lockinterruptible

	// Start the calculator thread
	new Thread(calculator, "Thread-Calculator").start();

    }

}
