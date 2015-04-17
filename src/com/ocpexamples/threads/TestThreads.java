package com.ocpexamples.threads;


public class TestThreads extends Thread {

    public static void main(String args[]) {
	System.out.println("In Main thread is: " + Thread.currentThread().getName());
//	CountThread countThread = new CountThread();
//	Thread t = new Thread(countThread);
//	t.setPriority(1);
//	t.start();
	StringBuffer sb= new StringBuffer("A");
	
	SynchronizationExample se1= new SynchronizationExample(sb);
	SynchronizationExample se2= new SynchronizationExample(sb);
	SynchronizationExample se3= new SynchronizationExample(sb);
//	SynchronizationExample se4= new SynchronizationExample(new StringBuffer("Q"));
	se1.start();
	se2.start();
	se3.start();
//	se4.start();
	
/**	FooRunnable fooRunnable= new FooRunnable();
	Thread t1= new Thread(fooRunnable, "Thread one");
	Thread t2= new Thread(fooRunnable, "Thread two");
	Thread t3= new Thread(fooRunnable, "Thread three");
	t1.start();
	t2.start();
	t3.start();*/
    }

}
