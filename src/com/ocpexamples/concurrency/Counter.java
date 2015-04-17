package com.ocpexamples.concurrency;

import java.util.concurrent.atomic.AtomicInteger;


public class Counter {
//    private int count;
    AtomicInteger  count= new AtomicInteger();
    
    public void increment(){
//	count++;
	count.getAndIncrement();
    }
    
    public int getValue(){
	return count.get();
    }

}
