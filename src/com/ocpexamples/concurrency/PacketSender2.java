package com.ocpexamples.concurrency;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PacketSender2 extends TimerTask {
	private static final int CLIENT_PORT = 1978;
	private static final int BUFFER_SIZE = 512;
	private DatagramSocket datagramSocket;

	public PacketSender2() throws SocketException {
		datagramSocket = new DatagramSocket(1979);
	}

	@Override
	public void run() {
		// int randomNumber= new Random().nextInt(1000);
		try {
			String messageToSend = "Current value is: "+ new Random().nextInt(1000);
			byte[] dataBytesToSend = messageToSend.getBytes();
			DatagramPacket datagramPacket = new DatagramPacket(dataBytesToSend,dataBytesToSend.length, new InetSocketAddress("localhost",CLIENT_PORT));
			System.out.println("--------------------------- sending a packet ");
			datagramSocket.send(datagramPacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SocketException {
		PacketSender2 packetSender = new PacketSender2();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(packetSender, 0, 3000);
	}
}
