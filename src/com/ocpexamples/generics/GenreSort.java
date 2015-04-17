package com.ocpexamples.generics;

import java.util.Comparator;


public class GenreSort implements Comparator<DVDInfo> {


    @Override
    public int compare(DVDInfo o1, DVDInfo o2) {
	
	return o1.getGenre().compareTo(o2.getGenre());
    }

}
