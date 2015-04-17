package com.ocpexamples.threads;


public class ThreadA {


    public static void main(String[] args) {
	ThreadB tb= new ThreadB(6);
	tb.start();
	
	synchronized (tb) {
	    try {
		System.out.println(Thread.currentThread().getName()+ " is waiting......");
		tb.wait();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	
	System.out.println(Thread.currentThread().getName()+ " finished waiting......");
	System.out.println(tb.getTotal());

    }

}
