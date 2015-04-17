package com.ocpexamples.garbagecollection;

import java.util.Date;


public class CheckGC {

    public CheckGC() {}

    public static void main(String[] args) {
	Runtime rt= Runtime.getRuntime();
	System.out.println("Total JVM memory: "+rt.totalMemory());
	System.out.println("Before memory: "+rt.freeMemory());
	
	Date d=null;
	
	for (int i = 0; i <10_000; i++) {
	   d= new Date();
	   d=null;
	}
	
	System.out.println("After memory: "+rt.freeMemory());
	rt.gc();
	System.out.println("After GC memory: "+rt.freeMemory());
	System.out.println("Available processors: "+rt.availableProcessors());
    }

}
