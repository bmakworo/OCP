package com.ocpexamples.threads;

public class Reader extends Thread {

    Calculator calc;

    public Reader(Calculator c, String name) {
	super(name);
	calc = c;
    }

    public void run() {
	synchronized (calc) {
	    try {
		System.out.println(Thread.currentThread().getName()+ " Waiting for calculation ........");
		calc.wait();
		
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}

	System.out.println(Thread.currentThread().getName()+" Finished waiting ");
	System.out.println(" Total is: "+ calc.getTotal());
    } 


    public static void main(String args[]) {
	final int number=6;
	Calculator calculator= new Calculator(number);
	new Reader(calculator,"Thread-A").start();
	new Reader(calculator,"Thread-B").start();
	new Reader(calculator,"Thread-C").start();
	new Reader(calculator,"Thread-D").start();

	//Start the calculator thread 
	new Thread(calculator,"Thread-Calculator").start();
    }

}
