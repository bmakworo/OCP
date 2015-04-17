package com.ocpexamples.concurrency;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.channels.IllegalBlockingModeException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkService implements Runnable {

    private final ServerSocket serverSocket;
    private final ExecutorService ex;

    public NetworkService(int poolSize, int port) throws IOException {
	serverSocket = new ServerSocket(port);
	ex = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public void run() {
	try {

//	    while (true) {
	    for (;;) {
		System.out.println("Waiting for client on port: "+serverSocket.getLocalPort());
		Socket clientSocket= serverSocket.accept();
		System.out.println("Server connected to: "+clientSocket.getRemoteSocketAddress());
		ex.execute(new Handler(clientSocket));
//		System.out.println("here2");
//		System.out.println(" ");
	    }
	} catch (IOException | SecurityException | IllegalBlockingModeException ex) {
	    ex.printStackTrace();
	    ((ExecutorService) ex).shutdown();
	}
	
	System.out.println("should not reach here!!!");
    }
    
    public static void main(String[] args) {
	try {
//	    NetworkService ns = new NetworkService(4, 1978);
	    new Thread(new NetworkService(4, 1978)).start();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
