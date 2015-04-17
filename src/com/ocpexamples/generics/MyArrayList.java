package com.ocpexamples.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MyArrayList {

    public MyArrayList() { }

    public static void main(String[] args) {
//	String[] s= {"Phillip", "is", "feeling"};
	List<String> otherList= Arrays.asList("Phillip", "is", "feeling");
	List<String> list= new ArrayList<>();
	((ArrayList)list).ensureCapacity(6);
	System.out.println(" "+list.size());
//	list.set(5, "aiiia!!!");
	list.add("Betty");
	list.add("is");
	list.add("feeling a little");
	list.add("down");
	System.out.println(" "+list.size());
	System.out.println(" "+list.get(2));
	System.out.println(" "+list.containsAll(otherList));
	list.remove("down");
	System.out.println(" "+list);
	list.set(list.indexOf("feeling a little"), "feeling great!!!");
	System.out.println(" "+list);
	list.clear();
	System.out.println(" "+list);
	
	Integer x= 567;
	Integer y=x;
	System.out.println(" "+(y==x));	
	y++;
	System.out.println("x =  "+x+ " y = "+y);
	System.out.println(" "+(y==x));	
	
	Integer i1= 1000;
	Integer i2= 1000;
	
//	if(i1==i2){
	    System.out.println("Are equal (==) "+(i1==i2));	 
//	}else if(i1.equals(i2)){
	    System.out.println("Are not equal (!=) "+(i1 != i2));
	    System.out.println("Are equal (.equals()) "+(i1.equals(i2)));	
//	}
	  
	 String[] s={"Gambia", "Angola", "Zambia", "Chad", "Uganda", "Kenya", "Botswana"};
	 List<String> countries= Arrays.asList(s);
	 System.out.println("Unsorted list of countries:  "+countries);
	 Collections.sort(countries);
	 System.out.println("Sorted list of countries:  "+countries);
	 //change the string[]
	 s[s.length-1]= "Mozambique";
//	 s[s.length-1]= "Lesotho";
	 
	 System.out.println("Sorted list of countries:  "+countries);
	 
	 //try changing the list and see if it reflects in the array
	 countries.set(2,"Tanzania");
	 
	 for (String string : s) {
	     System.out.print(string+" ");
	}
//	 Integer[] aa= new Integer[3];
    }

}
