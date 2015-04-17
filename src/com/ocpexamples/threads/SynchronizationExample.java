package com.ocpexamples.threads;

public class SynchronizationExample extends Thread {

    private StringBuffer stringBuffer;

    private static int num;

    public SynchronizationExample(StringBuffer sBuffer) {
	stringBuffer = sBuffer;
    }

    public void manipulateStringBuffer() {
	synchronized (stringBuffer) {
	    // synchronized (SynchronizationExample.class) {

	    for (int j = 0; j < 101; j++) {
		System.out.print(" " + stringBuffer + j);
	    }
	    char c = stringBuffer.charAt(0);
	    stringBuffer.setCharAt(0, ++c);
	    System.out.println("\n");
	    // }
	}
    }

    public static void testing() {
	StringBuilder builder = new StringBuilder("haha");
    }

    public void run() {
	// synchronized (stringBuffer) {
	manipulateStringBuffer();
	// }

    }

}
