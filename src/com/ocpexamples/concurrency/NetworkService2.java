package com.ocpexamples.concurrency;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.channels.IllegalBlockingModeException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkService2 implements Runnable {

    private static final int SERVER_PORT = 1978;
    private final DatagramSocket datagramSocket;
    private final ExecutorService ex;
    private static final int BUFFER_SIZE = 512;

    public NetworkService2(int poolSize) throws IOException {
	datagramSocket = new DatagramSocket(SERVER_PORT);
	ex = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public void run() {
	try {

	    while (true) {
		byte[] buffer = new byte[BUFFER_SIZE];
		DatagramPacket datagramPacket = new DatagramPacket(buffer, BUFFER_SIZE);
		System.out.println("Server Listening on port: " + SERVER_PORT);
		datagramSocket.receive(datagramPacket);
		System.out.println("Server connected to: " + datagramPacket.getPort());
		ex.execute(new Handler2(datagramPacket));
	    }
	} catch (IOException | SecurityException | IllegalBlockingModeException ex) {
	    ex.printStackTrace();
	    ((ExecutorService) ex).shutdown();
	}

	System.out.println("should not reach here!!!");
    }

    public static void main(String[] args) {
	try {
	    new Thread(new NetworkService2(4)).start();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
