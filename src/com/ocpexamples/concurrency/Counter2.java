package com.ocpexamples.concurrency;

import java.util.concurrent.atomic.AtomicInteger;


public class Counter2 {
    private int count;
//    AtomicInteger  count= new AtomicInteger();
    
    public void increment(){
	count++;
    }
    
    public int getCount(){
	return count;
    }

}
