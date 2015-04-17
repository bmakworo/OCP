package com.ocpexamples.misc;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;

public final class Util {

    private static final String LOG4J_PROPERTIES = "/log4j.properties";

    public Util() {}
    
    public static String getCurrentDirectory(){
	return System.getProperty("user.dir");
    }

    public static void initLogger() {
//	String currentdir = System.getProperty("user.dir");
	String currentdir= getCurrentDirectory();
	System.out.println("Reading log4j properties file: " + LOG4J_PROPERTIES + " ...");
	if (new File(currentdir + LOG4J_PROPERTIES).exists()) {
	    PropertyConfigurator.configureAndWatch(currentdir + LOG4J_PROPERTIES);
	} else {
	    System.out.println("FAILED - " + currentdir + " Not Found.");
	}
    }

}
