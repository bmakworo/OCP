package com.ocpexamples.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample extends Thread {

    private String string;
    private Counter2 countObject;
    int count;
    private final int NUM=1000;
    private final Lock lock = new ReentrantLock(true);

    public ReentrantLockExample() {}
    
    public ReentrantLockExample(String s) {
	string = s;
    }
    
    public ReentrantLockExample(int n) {
	count = n;
    }
    
    public ReentrantLockExample(Counter2 obj) {
	countObject = obj;
    }

    public void manipulateStringBuffer() {

	Lock lock = new ReentrantLock();
	lock.lock();
	try {
	    // synchronized (string) {
	    for (int j = 0; j < 226; j++) {
		System.out.print(" " + string + j);
		char[] c = new char[] { string.charAt(0) };
		c[0]++;
		string = new String(c);
	    }
	    // }
	    System.out.println("  " + Thread.currentThread().getName() + " finished.\n");
	} finally {
	    lock.unlock();
	}

    }
    
    
    public void incrementCount() throws InterruptedException {

	boolean locked=lock.tryLock(10,TimeUnit.MILLISECONDS);
	try {
//	    synchronized (count) {
	    for (int j = 0; j <= NUM; j++) {
//		System.out.print("["+Thread.currentThread().getId()+"]:" + count++ +" " );
		System.out.print(count++ +" " );
	    }
	    System.out.println("  " + Thread.currentThread().getName() +"  "+Thread.currentThread().getId()+ " finished.\n");
	} finally {
	   if(locked){ lock.unlock();}
	}
//	    }
    }
    
    public void incrementCountWithSynchronizedBlock() {

	synchronized (countObject) {
	    for (int i = 0; i < NUM; i++) {
		countObject.increment();

	    }
	}
    }
    
    public synchronized void incrementCountWithSynchronizedMethod() {
	for (int i = 0; i < NUM; i++) {
	    countObject.increment();

	}
    }
    
    public void incrementCountWithReentrantLock() {

	lock.lock();
	try {
	    for (int i = 0; i < NUM; i++) {
		countObject.increment();

	    }
	}finally{
	    lock.unlock();
	}
    }
    
    
    public void incrementCountWithReentrantLockTry() throws InterruptedException {

	lock.tryLock(3, TimeUnit.MICROSECONDS);
	try {
	    for (int i = 0; i < NUM; i++) {
		countObject.increment();

	    }
	}finally{
	    lock.unlock();
	}
    }

    public void run() {
//	manipulateStringBuffer();
//	    try {
//		incrementCount();
//	    } catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	    }
	    
//	incrementCountWithReentrantLock(); 
//	incrementCountWithSynchronizedBlock();
//	incrementCountWithSynchronizedMethod();
	try {
	    incrementCountWithReentrantLockTry();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	
    }

    public static void main(String[] args) throws InterruptedException {

	// StringBuffer sb = new StringBuffer("A");
	String atomicStringBuffer = "A";
	int num = 0;
	// AtomicReference<String> atomicStringBuffer = new AtomicReference<String>(sb);

//	ReentrantLockExample are1 = new ReentrantLockExample(atomicStringBuffer);
//	ReentrantLockExample are2 = new ReentrantLockExample(atomicStringBuffer);
//	ReentrantLockExample are3 = new ReentrantLockExample(atomicStringBuffer);
	
//	ReentrantLockExample are1 = new ReentrantLockExample();//num);
//	ReentrantLockExample are2 = new ReentrantLockExample();//num);
//	ReentrantLockExample are3 = new ReentrantLockExample();//num);
	Counter2 counter = new Counter2();
	ReentrantLockExample are1 = new ReentrantLockExample(counter);
	ReentrantLockExample are2 = new ReentrantLockExample(counter);
	ReentrantLockExample are3 = new ReentrantLockExample(counter);
	
//	ReentrantLockExample are1 = new ReentrantLockExample(num);
//	ReentrantLockExample are2 = new ReentrantLockExample(num);
//	ReentrantLockExample are3 = new ReentrantLockExample(num);

	are1.start();
	are2.start();
	are3.start();
	are1.join();
	are2.join();
	are3.join();

	System.out.println(counter.getCount() + " " + Thread.currentThread().getName());
    }
}
