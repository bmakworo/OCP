package com.ocpexamples.generics;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.ocpexamples.misc.Util;

public class DVDInfo implements Comparable<DVDInfo> {

    //make the variables that are used to generate the hashCode immutable
    private final String title;
    private final String genre;
    private final String leadActor;
    private int views;

    public DVDInfo(String title, String genre, String leadActor, String s) {
	this.title = title;
	this.genre = genre;
	this.leadActor = leadActor;
	this.views= Integer.parseInt(s);
    }
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    
    
    /**
     * @return the leadActor
     */
    public String getLeadActor() {
        return leadActor;
    }

    /**
     * @return the views
     */
    public Integer getViews() {
        return views;
    }

    @Override
    public String toString() {
	return "[title=" + title + ", genre=" + genre + ", leadActor=" + leadActor + ", viewed=" + views + "]\n";
    }

    private static Collection<DVDInfo> poulateList() {
	List<String> list = (ArrayList<String>) readDVDInfoFile();
	List<DVDInfo> info = new ArrayList<>();

	if (list != null) {
	    for (String string : list) {
		String[] s = string.split("/");

		info.add(new DVDInfo(s[0], s[1], s[2],s[3]));
	    }
	}

	return info;
    }

    private static Collection<String> readDVDInfoFile() {

	Path p = Paths.get(Util.getCurrentDirectory(), "resources/dvdInfo22.txt");
	System.out.println(p);
	Charset charset = Charset.forName("US-ASCII");
	List<String> infoList = new ArrayList<>();

	try (BufferedReader reader = Files.newBufferedReader(p, charset)) {
	    String line = null;
	    while ((line = reader.readLine()) != null) {
		infoList.add(line);
		// System.out.println(line);
	    }
	} catch (IOException x) {
	    System.err.format("IOException: %s%n", x);
	}

	 System.out.println(infoList.get(0));
	return infoList;
    }

    public static void main(String[] args) {
	List<DVDInfo> dvdInfoList = new ArrayList<>();
	dvdInfoList = (ArrayList<DVDInfo>) poulateList();
	//output as read from file
	System.out.println("********************************* output as read from file");
	System.out.println(dvdInfoList);
	
	Collections.sort(dvdInfoList);
	System.out.println("********************************* output after sorting by title using comparable");
	System.out.println(dvdInfoList);
	
	Collections.sort(dvdInfoList, new GenreSort());
	System.out.println("********************************* output after sorting by genre using comparator");
	System.out.println(dvdInfoList);
	
	Collections.sort(dvdInfoList, new ViewsSort());
	System.out.println("********************************* output after sorting by number of views using comparator");
	System.out.println(dvdInfoList);
	
	iterateOverCollection(dvdInfoList);
	
	DVDInfo[] dvdInfoArray= new DVDInfo[30];
	dvdInfoArray= dvdInfoList.toArray(dvdInfoArray);
	
	iterateOverCollection(dvdInfoList);
	
	System.out.println("********************************* Testing no duplicates");
//	HashSet<DVDInfo> set= new HashSet<>();

	
	Set<DVDInfo> dvdInfoSet= new HashSet<>(dvdInfoList);
//	dvdInfoSet.
	System.out.println(dvdInfoSet);
	iterateOverCollection(dvdInfoSet);
	
	System.out.println("size before adding duplicate "+dvdInfoSet.size());
	System.out.println("testing duplicate "+ dvdInfoSet.add(new DVDInfo("2001", "romcom", "Kate, Hudson","63")));//2001/romcom/Kate, Hudson/63
	System.out.println("********************************* After adding duplicate");
	System.out.println("size after adding duplicate "+dvdInfoSet.size());
	System.out.println(dvdInfoSet);
	
	Set<String> dummySet= new HashSet<>();
	dummySet.add("banana");
	dummySet.add("apple");
	dummySet.add("pinapple");
	dummySet.add("banana");
	dummySet.add("orange");
	System.out.println(dummySet);
    }

    private static void iterateOverCollection(Collection<DVDInfo> dvdInfoList) {
	System.out.println("********************************* using the iterator");
	Iterator<DVDInfo> iterator= dvdInfoList.iterator();
	while (iterator.hasNext()) {
	    DVDInfo dvdInfo = (DVDInfo) iterator.next();
	    System.out.println(dvdInfo.getTitle()+ " "+dvdInfo.getTitle().hashCode()+ " "+dvdInfo.hashCode());
	}
	
    }

    @Override
    public int compareTo(DVDInfo o) {
//	System.out.println("*********************************");
	return title.compareTo(o.getTitle());
    }
    
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
		
	if ((obj instanceof DVDInfo) && ((DVDInfo) obj).getTitle().equals(this.title) && ((DVDInfo) obj).getLeadActor().equals(this.leadActor)) {
	    return true;
//	if (obj instanceof DVDInfo) {	    
//	    DVDInfo info=(DVDInfo) obj;	
//	    return  (info.getTitle()== this.title && info.getGenre()==this.genre && info.getLeadActor()== this.leadActor)? true:false;
	} else {
	    return false;
	}
    }

    public int hashCode() {
	return title.length()+ leadActor.length();

    }

}
