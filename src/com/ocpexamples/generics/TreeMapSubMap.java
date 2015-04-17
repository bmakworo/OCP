package com.ocpexamples.generics;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class TreeMapSubMap {

    public static void main(String[] args) {
	Map<String, String> treeMap= new TreeMap<>();
	String[][] s= {{"a","ant"},{"d","dog"},{"h","horse"},{"g","goose"}};
	new TreeMapSubMap().addStringsToMap(s,treeMap);
	System.out.println(treeMap);
	
	SortedMap<String, String> subMap= ((TreeMap<String, String>)treeMap).subMap("b",true, "g",true);
	System.out.println("********************************* submap ");
	System.out.println(subMap);
	
	treeMap.put("b", "badger");//alter the original map
	System.out.println("********************************* after altering original map");
	System.out.println("ORIGINAL: "+treeMap);//check changes to original	
	System.out.println("SUBMAP: "+subMap);//check changes to subMap	
	
	subMap.put("e", "eagle");//alter the submap
	System.out.println("********************************* after altering submap");
	System.out.println("ORIGINAL: "+treeMap);//check changes to original	
	System.out.println("SUBMAP: "+subMap);//check changes to subMap	
	
	treeMap.put("k", "kite");//alter the original with out or range value
	System.out.println("********************************* after altering original with out of range key");
	System.out.println("ORIGINAL: "+treeMap);//check changes to original	
	System.out.println("SUBMAP: "+subMap);//check changes to subMap	
	
	subMap.put("r", "racoon");//alter the submap with out or range value
	System.out.println("********************************* after altering submap with out of range key");
	System.out.println("ORIGINAL: "+treeMap);//check changes to original	
	System.out.println("SUBMAP: "+subMap);//check changes to subMap	
	
	
	 
    }
    
    private void addStringsToMap(String[][] sa, Map<String, String> m){
	for (String[] string : sa) {
//	    System.out.println(string[0]);
	    m.put(string[0], string[1]);
	}
    }

}
