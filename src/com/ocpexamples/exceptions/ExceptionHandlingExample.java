package com.ocpexamples.exceptions;

public class ExceptionHandlingExample {

    public ExceptionHandlingExample() {
    }

    public static void main(String[] args) {
	try {
	    String stringToReverse= "Betty";
	    ExceptionHandlingExample ehe= new ExceptionHandlingExample();
	    
	    System.out.println("String "+stringToReverse+" in reverse is "+ehe.reverse(stringToReverse));
	    System.out.println("String "+stringToReverse+" in reverse is "+ehe.reverse(""));
	} catch (IllegalArgumentException iae) {
	    iae.printStackTrace();
	}
    }

    public String reverse(String s) {

	if(s== null || s.trim().isEmpty()){
	    throw new IllegalArgumentException("Invalid input");
	}
	
	int slength= s.length();
	int sIndex=slength-1;
	char[] c = new char[slength];

	for (int i = 0; i < slength; i++) {
	    c[i]= s.charAt(sIndex);
	    sIndex--;
	}
	
	return new String(c);

    }

}
