package com.ocpexamples.generics;

import java.util.Arrays;
import java.util.Comparator;

public class SearchObjArray {

    static class ResortComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {

	    return o2.compareTo(o1);
	}

    }

    private static String[] s;

    public static void main(String[] args) {
	s = new String[] { "one", "two", "three", "four" };
	// sort the array before searching
	Arrays.sort(s);
	for (String string : s) {
	    System.out.print(string + " ");
	}
	System.out.println("\nSearching for \"three\": " + Arrays.binarySearch(s, "three"));

	System.out.println("------------------ Now reverse sort");
	ResortComparator rc = new ResortComparator();
	Arrays.sort(s, rc);
	for (String string : s) {
	    System.out.print(string + " ");

	}
	System.out.println("\nSearching for \"three\" after reverse sorting: " + Arrays.binarySearch(s, "three",rc));
    }

}
