package com.ocpexamples.concurrency;

import java.util.concurrent.atomic.AtomicReference;


public class Main {

    public static void main(String[] args) throws InterruptedException {
	Counter counter = new Counter();
	IncrementThread it1 = new IncrementThread(counter);
	IncrementThread it2 = new IncrementThread(counter);
	it1.start();
	it2.start();
	it1.join();
	it2.join();
	System.out.println("counter value= " + counter.getValue());

//	StringBuffer sb = new StringBuffer("A");

//	AtomicReference<StringBuffer> sb = new AtomicReference<StringBuffer>(new StringBuffer("A"));
	
	String s ="A";
	AtomicReference<String> sb = new AtomicReference<String>(s);
	AtomicReferenceExample se1 = new AtomicReferenceExample(sb);
//	AtomicReferenceExample se2 = new AtomicReferenceExample(sb);
//	AtomicReferenceExample se3 = new AtomicReferenceExample(sb);
	// SynchronizationExample se4= new SynchronizationExample(new StringBuffer("Q"));
	se1.start();
//	se2.start();
//	se3.start();
    }

}
