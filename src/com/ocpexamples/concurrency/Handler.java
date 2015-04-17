package com.ocpexamples.concurrency;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Handler implements Runnable {

    private final Socket socket;

    Handler(Socket socket) {
	this.socket = socket;
	 System.out.println("-------------------- NEW HANDLER");
	 System.out.println("-------------------- local port = " + this.socket.getLocalPort());
	 System.out.println("-------------------- port = " + this.socket.getLocalPort());
    }

    @Override
    public void run() {
	// read and service request on socket
	// byte[] buffer= new
	DataInputStream dis=null;
	try {
	    dis = new DataInputStream(socket.getInputStream());
	    System.out.println("---------------------------DATA RECEIVED");
	    // System.out.println("-------------------- size of packet = " + buffer.length);
	    System.out.println("-------------------- address = " + socket.getPort());
	    System.out.println("-------------------- message = " + dis.readUTF());
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	System.out.println("Handler "+Thread.currentThread().getName()+" has finished");
	System.out.println(" ");
	
	try {
	    dis.close();
	    socket.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
