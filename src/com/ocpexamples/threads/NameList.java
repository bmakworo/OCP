package com.ocpexamples.threads;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NameList {

    private List names = Collections.synchronizedList(new LinkedList<String>());

    public void add(String name) {
	names.add(name);
    }

    public String removeFirst() {
	if (names.size() > 0) {
	    return (String) names.remove(0);
	} else {
	    return null;
	}
    }
    
    public static void main(String args[]){
//	System.out.println("Here");
	final NameList nameList= new NameList();
	nameList.add("Kwames");
	
	class NameDropper extends Thread{
	    public void run(){
		String name = nameList.removeFirst();
		System.out.println(name);
	    }
	}
	
	Thread t1=  new NameDropper();
	Thread t2=  new NameDropper();
	Thread t3=  new NameDropper();
	t1.start();
	t2.start();
	t3.start();
	
    }

}
