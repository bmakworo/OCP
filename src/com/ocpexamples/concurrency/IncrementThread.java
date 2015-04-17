package com.ocpexamples.concurrency;


public class IncrementThread extends Thread {

    private Counter counter;
    
    public IncrementThread(Counter c){
	this.counter=c;
    }
    
    public void run(){
//	synchronized (counter) {
		for (int i = 0; i < 10000; i++) {
		    counter.increment();
//		    String s= Thread.currentThread().getName() + " is incrementing";
//		    System.out.println(Thread.currentThread().getName() + " is incrementing");
		} 
//	}

    }
}
