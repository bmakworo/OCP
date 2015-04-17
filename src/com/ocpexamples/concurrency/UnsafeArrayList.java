package com.ocpexamples.concurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class UnsafeArrayList implements Runnable{
//    private List<Integer> list= new ArrayList<>();
    private List<Integer> list2= new CopyOnWriteArrayList<>();

    public UnsafeArrayList() {
	for (int i = 0; i < 1000;i++) {
	    list2.add(i);
	}
    }
    
    @Override
    public void run() {
	String threadName = Thread.currentThread().getName();
	
	for (Integer integer : list2) {
	    if(!list2.isEmpty()){
		list2.remove(0);
	    }
	}
	
//	while (!list2.isEmpty()) {
//	    list2.remove(0);
////	    System.out.println(threadName+" removed "+list.remove(0));
//	}
	
	 System.out.println(threadName+" removed items.List size now= "+list2.size());
	
    }
    
    

    public static void main(String[] args) {
	UnsafeArrayList unsafeArrayList= new UnsafeArrayList();
	Thread t1= new Thread(unsafeArrayList);
	Thread t2= new Thread(unsafeArrayList);
	Thread t3= new Thread(unsafeArrayList);
	t1.start();
	t2.start();
	t3.start();
	
	System.out.println(Thread.currentThread().getName()+" finished ");
    }



}
