/**
 * 
 */
package com.ocpexamples.generics;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bmakworo
 *
 */
public class EqualsTest {

    /**
     * 
     */
    public EqualsTest() {
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	Moof m1 = new Moof(8,"m1");
	Moof m2 = new Moof(8,"m1");
	Moof m3 = new Moof(3,"m3");
	Moof m4 = new Moof(2,"m4");
	Moof m5 = new Moof(1,"m5");
	System.out.println("Moof m1.equals(m2) ? "+ m1.equals(m2));
	System.out.println("Moof m1==m2 ? "+ (m1==m2));
	System.out.println("Moof m3.equals(m2) ? "+ m3.equals(m2));
	
	Set<Moof> dummySet= new HashSet<>();
	dummySet.add(m1);
	dummySet.add(m2);
	dummySet.add(m3);
	dummySet.add(m4);
	dummySet.add(m5);
	System.out.println(dummySet);
//	dummySet.
    }

}

class Moof {

    private int moofValue;
    private String name;

    Moof(int val, String name) {
	moofValue = val;
	this.name=name;
    }
    
    /**
     * @return the moofValue
     */
    public int getMoofValue() {
	return moofValue;
    }
    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
	return "[name=" + name + ", moofValue=" + moofValue + "]\n";
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
//    @Override
//    public boolean equals(Object obj) {
//	if (this == obj) {
//	    return true;
//	}
//	if (obj == null) {
//	    return false;
//	}
//
//	if ((obj instanceof Moof) && ((Moof) obj).getMoofValue() == this.moofValue) {
//	    return true;
//	} else {
//	    return false;
//	}
//    }
//
//    public int hashCode() {
//	return moofValue;
//
//    }
    
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}

	if ((obj instanceof Moof) && ((Moof) obj).getName().equals(this.name)) {// && ((Moof) obj).getMoofValue() == this.moofValue) {
	    return true;
	} else {
	    return false;
	}
    }

    public int hashCode() {
	return name.length();

    }

}
