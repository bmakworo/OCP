package com.ocpexamples.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;

public class NameSort {

    public static void main(String[] args) {
	Name nameArray[] = { new Name("John", "Smith"),
			    new Name("Karl", "Ng"),
			    new Name("Jeff", "Smith"),
			    new Name("Tom", "Rich") };

	List<Name> names = Arrays.asList(nameArray);
	System.out.println("************************** sort by Last name");
	Collections.sort(names);
	System.out.println(names);
	System.out.println("************************** sort by Last name reverse");
	Collections.reverse(names);
	System.out.println(names);
	System.out.println("************************** sort by first name");
	FirstNameSort fSort= new FirstNameSort();
	Collections.sort(names, fSort);	
	System.out.println(names);
    }

}

class Name implements Comparable<Name> {

    private final String firstName, lastName;

    public Name(String firstName, String lastName) {
	if (firstName == null || lastName == null)
	    throw new NullPointerException();
	this.firstName = firstName;
	this.lastName = lastName;
    }

    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    @Override
    public String toString() {
        
        return "Last name: "+lastName+ "    First name: "+firstName+"\n";
    }
    
    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}

	if (!(obj instanceof Name))
	    return false;

	if (obj == this) {
	    return true;
	}

	Name name = (Name) obj;
	return this.lastName.equals(name.getLastName()) && this.firstName.equals(name.getFirstName());
    }
    
    @Override
    public int hashCode() {
       
        return this.lastName.hashCode()+this.firstName.hashCode();
    }
    
    @Override
    public int compareTo(Name name) {
	int compare= lastName.compareTo(name.lastName);
	return ( compare != 0 ? compare: firstName.compareTo(name.getFirstName()));
    }
}


class FirstNameSort implements Comparator<Name> {

    @Override
    public int compare(Name n1, Name n2) {
	return n1.getFirstName().compareTo(n2.getFirstName());
//	return n2.getFirstName().compareTo(n1.getFirstName());//will return results in reverse order
    }
}
