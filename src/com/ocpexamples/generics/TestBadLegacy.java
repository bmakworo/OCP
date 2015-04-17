package com.ocpexamples.generics;

import java.util.ArrayList;
import java.util.List;


public class TestBadLegacy {

    public static void main(String[] args) {
	List<Integer> list= new ArrayList<>();
	list.add(2);
	list.add(9);
	list.add(4); 
	
	Inserter inserter= new Inserter();
	inserter.insert(list);
	System.out.println(list);
    }

}

class Inserter {

    public void insert(List list) {
//	list.add(new Integer(10));
	list.add("aiiia!");
    }

}
