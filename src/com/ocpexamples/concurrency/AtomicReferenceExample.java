package com.ocpexamples.concurrency;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicReferenceExample extends Thread {

    private AtomicReference<String> string;
    private static int num;

    public AtomicReferenceExample(AtomicReference<String> sBuffer) {
	string = sBuffer;
    }

    public void  manipulateStringBuffer() {

//	Lock lock = new ReentrantLock();
//	lock.lock();
//	try {
	synchronized (string) {
	    
	
	    for (int j = 0; j < 25; j++) {

		char[] c = new char[] { string.get().charAt(0) };
		c[0]++;
		// System.out.print(" " + ++c[0]);
//		String aa="0";
//		System.out.print(" " + aa.charAt(0));
//		char[] c2 = new char[] { aa.charAt(0) };
//		c2[0]++;
		string.set(new String(c));
		System.out.print(" " + string + j);
	    }
	    
	}
	    System.out.println("  "+Thread.currentThread().getName()+ " finished.\n");
//	} finally {
//	    // TODO: handle exception
//	}

    }

    public void run() {
	manipulateStringBuffer();
    }

    public static void main(String[] args) {

	// StringBuffer sb = new StringBuffer("A");
	String sb = "0";
	AtomicReference<String> atomicStringBuffer = new AtomicReference<String>(sb);

	AtomicReferenceExample are1 = new AtomicReferenceExample(atomicStringBuffer);
	AtomicReferenceExample are2 = new AtomicReferenceExample(atomicStringBuffer);
	AtomicReferenceExample are3 = new AtomicReferenceExample(atomicStringBuffer);
	// SynchronizationExample se4= new SynchronizationExample(new StringBuffer("Q"));
	are1.start();
	are2.start();
	are3.start();
    }
}
