package com.ocpexamples.garbagecollection;


public class GarbageCollection {

    GarbageCollection gColl;
    private String name;
    
    public GarbageCollection(String name){
	this.name=name;
    }
    
    public static void main(String[] args){
	GarbageCollection gCollection2 =new GarbageCollection("gCollection2");
	GarbageCollection gCollection3 =new GarbageCollection("gCollection3");
	GarbageCollection gCollection4 =new GarbageCollection("gCollection4");
	
	gCollection2.gColl=gCollection3;
	gCollection3.gColl=gCollection4;
	gCollection4.gColl=gCollection2;
	
	System.out.print(gCollection2.gColl+"  ");
	System.out.print(gCollection3.gColl+"  ");
	System.out.print(gCollection4.gColl+"  ");
    }
    
    public String toString(){
	return this.name;
	
    }

}
