package com.ocpexamples.generics;

import java.util.Comparator;


public class ViewsSort implements Comparator<DVDInfo> {

    @Override
    public int compare(DVDInfo o1, DVDInfo o2) {
	return o1.getViews().compareTo(o2.getViews());
    }

}
