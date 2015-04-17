package com.ocpexamples.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ocpexamples.misc.Util;

/**
 * Populates an array with random numbers
 * 
 * @author bmakworo
 *
 */

public class RandomInitRecursiveAction extends RecursiveAction {

    /** log4j logger */
    private static final Logger LOG = LogManager.getLogger(RandomInitRecursiveAction.class);
    
    private static final int THRESHOLD = 10_000;
    private int[] data;
    private int start;
    private int end;

    public RandomInitRecursiveAction(int[] data, int start, int end) {
	this.data = data;
	this.start = start;
	this.end = end;
    }

    @Override
    protected void compute() {
	if (end - start <= THRESHOLD) { // is a manageable amount of work
	    for (int i = start; i < end; i++) {
		data[i] = ThreadLocalRandom.current().nextInt();
		// LOG.debug(data[i]);
	    }
	} else {
	    int halfWay = ((end - start) / 2) + start;
	    RandomInitRecursiveAction a1 = new RandomInitRecursiveAction(data, start, halfWay);
	    // a1.fork(); //queue half of the task
	    RandomInitRecursiveAction a2 = new RandomInitRecursiveAction(data, halfWay, end);
	    // a2.compute(); //Work on the right hand of the task
	    // a1.join(); // wait for queued task to complete
	    invokeAll(a2, a1);
	}

	// log.debug("Array size= ", data.length);
//	LOG.debug(data[data.length - 1]);
    }

    public static void main(String[] args) {
	/* Initialise log4j */
	Util.initLogger();

	int[] data = new int[10_000_000];
	ForkJoinPool fjp = new ForkJoinPool();
	RandomInitRecursiveAction action = new RandomInitRecursiveAction(data, 0, data.length);
	fjp.invoke(action);

    }

}
