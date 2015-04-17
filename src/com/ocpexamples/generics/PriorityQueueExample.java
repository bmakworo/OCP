package com.ocpexamples.generics;

import java.util.Comparator;
import java.util.PriorityQueue;


public class PriorityQueueExample {
    
    static class PQsort implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
	
	    return o2 - o1; //inverse sort
	}

    }

    public static void main(String[] args) {
	int[] ia= {1,5,3,7,6,9,8};
	PriorityQueue<Integer> queue= new PriorityQueue<>();
	PriorityQueueExample pqe=new PriorityQueueExample();
		
	pqe.loadQueue(queue, ia);
	System.out.println("Loaded queue values: "+queue);
	
	pqe.pollQueue(queue, ia);
	System.out.println("Queue values after polling: "+queue);
	
	pqe.loadQueue(queue, ia);
	System.out.println("Queue values after reloading : "+queue);
	System.out.println("Peeking queue : " +queue.peek()+" ");
//	pqe.peekQueue(queue, ia);
	
	PQsort pqs=  new PQsort();
//	queue = new PriorityQueue<>(10, pqs);
	
	PriorityQueue<Integer> queue2= new PriorityQueue<Integer>(10, pqs);
	pqe.loadQueue(queue2, ia);
	System.out.println("Queue values after reloading with comparator: "+queue2);
	
	pqe.pollQueue(queue2, ia);
	System.out.println("Queue values after polling inverse sorted queue: "+queue2);
	
    }

    private void loadQueue(PriorityQueue<Integer> q, int[] ia) {
	System.out.println("********************************* loading queue ");
	for (int i : ia) { //load the queue
	    q.offer(i);
	} 	
    }
    
    private void pollQueue(PriorityQueue<Integer> queue, int[] ia) {
	System.out.println("********************************* polling queue ");
	for (int i : ia) { //load the queue
	    System.out.print(queue.poll()+" ");
	} 
	
	 System.out.println("");
    }
    
}
