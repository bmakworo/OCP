package com.ocpexamples.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ocpexamples.misc.Util;

public class Fibonacci extends RecursiveTask<Integer> {

    /** log4j logger */
    private static final Logger LOG = LogManager.getLogger(Fibonacci.class);

    final int n;

    Fibonacci(int n) {
	this.n = n;
	LOG.debug(n);
    }


    @Override
    protected Integer compute() {
	if (n <= 10)
	    return n;
	Fibonacci f1 = new Fibonacci(n - 1);
	f1.fork();
	Fibonacci f2 = new Fibonacci(n - 2);
	return f2.compute() + f1.join();
    }

    public static void main(String[] args) {
	Util.initLogger();
	ForkJoinPool forkJoinPool =  new ForkJoinPool();
	Fibonacci fib= new Fibonacci(30);
	forkJoinPool.invoke(fib);
    }

}
