package com.ocpexamples.concurrency;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PacketSender extends TimerTask {

    private static final int CLIENT_PORT = 1978;
    private static final int BUFFER_SIZE = 512;
    private Socket clientSocket;

    public PacketSender() throws UnknownHostException, IOException {
	clientSocket = new Socket("localhost", CLIENT_PORT);
    }

    @Override
    public void run() {
	
	try {
	    String messageToSend = "New Message.Current value is: " + new Random().nextInt(1000);
	    System.out.println("---------------Connecting to: "+CLIENT_PORT); 
	    System.out.println("---------------Client local port: "+clientSocket.getLocalPort()); 
	    System.out.println("------------------ Just connected to: " + clientSocket.getRemoteSocketAddress());
	    System.out.println("--------------------------- sending message: "+messageToSend);
//	    OutputStream os = clientSocket.getOutputStream();
	    DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
	    dos.writeUTF(messageToSend);
//	    dos.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	 System.out.println(" ");

//	try {
//	    dos.close();
//	} catch (IOException e) {
//	    e.printStackTrace();
//	}
    }

    public static void main(String[] args) {
	PacketSender packetSender;
	try {
	    packetSender = new PacketSender();
	    Timer timer = new Timer();
	    timer.scheduleAtFixedRate(packetSender, 0, 3000);
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
