package com.ocpexamples.concurrency;

import java.net.DatagramPacket;

public class Handler2 implements Runnable {

    private final DatagramPacket datagramPacket;

    Handler2(DatagramPacket datagramPacket) {
	this.datagramPacket = datagramPacket;
	System.out.println("-------------------- NEW HANDLER");
//	System.out.println("-------------------- local port = " + this.socket.getLocalPort());
//	System.out.println("-------------------- port = " + this.socket.getLocalPort());
    }

    @Override
    public void run() {
	// read and service request on socket
	byte[] buffer = datagramPacket.getData();
	System.out.println("---------------------------DATA RECEIVED");
	System.out.println("-------------------- size of packet = " + buffer.length);
	System.out.println("-------------------- address = " + datagramPacket.getPort());
	System.out.println("-------------------- messega = " + new String(datagramPacket.getData()));

//	System.out.println("Handler " + Thread.currentThread().getName() + " has finished");
//	System.out.println(" ");

    }
}
