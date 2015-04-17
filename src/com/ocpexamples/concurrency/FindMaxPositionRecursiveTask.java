package com.ocpexamples.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ocpexamples.misc.Util;

public class FindMaxPositionRecursiveTask extends RecursiveTask<Integer> {

    /** log4j logger */
    private static final Logger LOG = LogManager.getLogger(FindMaxPositionRecursiveTask.class);

    private static final int THRESHOLD = 10_000;
    private int[] data;
    private int start;
    private int end;

    public FindMaxPositionRecursiveTask(int[] data, int start, int end) {
	this.data = data;
	this.start = start;
	this.end = end;
    }

    @Override
    protected Integer compute() {
	if (end - start <= THRESHOLD) { // is a manageable amount of work
	    int position = 0;
	    for (int i = start; i < end; i++) {
		if (data[i] > data[position]) {
		    position = i;
		}
	    }

	    LOG.debug("Task too small to divide.");
	    return position;
	} else { // Task too big split it
	    LOG.debug("Dividing task.");

	    int halfWay = ((end - start) / 2) + start;
	    FindMaxPositionRecursiveTask fMaxPosition1 = new FindMaxPositionRecursiveTask(data, start, halfWay);
	    fMaxPosition1.fork(); // queue half of the task
	    
	    FindMaxPositionRecursiveTask fMaxPosition2 = new FindMaxPositionRecursiveTask(data, halfWay, end);
	    int position2 = fMaxPosition2.compute(); // Work on the right hand of the task
	    int position1 = fMaxPosition1.join(); // wait for queued task to complete

	    if (data[position1] > data[position2]) {
		return position1;
	    } else if (data[position1] < data[position2]) {
		return position2;
	    } else {
		return position1 < position2 ? position1 : position2;
	    }
	}
    }

    public static void main(String[] args) {
	/* Initialise log4j */
	Util.initLogger();

	int[] data = new int[30_000_000];
	ForkJoinPool fjp = new ForkJoinPool();
	RandomInitRecursiveAction action = new RandomInitRecursiveAction(data, 0, data.length);
	fjp.invoke(action);

	FindMaxPositionRecursiveTask fMaxPositionTask = new FindMaxPositionRecursiveTask(data, 0, data.length);
	Integer position = fjp.invoke(fMaxPositionTask);
	LOG.debug("Position " + position + " , value " + data[position]);
    }

}
