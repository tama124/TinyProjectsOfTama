package tama.edu.socket.chatting.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			System.out.println("Client 1");
			final DatagramSocket datagramSocket = new DatagramSocket();
			final Scanner scInput = new Scanner(System.in);
			
			System.out.println("Enter ip address: ");
			String ip = scInput.nextLine();
			
			System.out.println("Enter port: ");
			final int port = scInput.nextInt();
			
			byte[] sendData = new byte[1024];
			sendData = new String("").getBytes();
			InetAddress ipAddress = InetAddress.getByName(ip);
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, ipAddress, port);
			datagramSocket.send(sendPacket);

			System.out.println("Start chating:");
			
			// sending thread
			new Thread(new Runnable() {
				
				public void run() {
					while (true) {
						try {
							String message = scInput.nextLine();
							byte[] sendData = new byte[1024];
							sendData = message.getBytes();
							InetAddress ipAddress = InetAddress.getByName("localhost");
							DatagramPacket sendPacket = new DatagramPacket(sendData,
									sendData.length, ipAddress, port);
							datagramSocket.send(sendPacket);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
			}).start();

			// receiving thread
			new Thread(new Runnable() {
				
				public void run() {
					while (true) {
						try {
							byte[] receiveData = new byte[1024];
							DatagramPacket receivePacket = new DatagramPacket(receiveData,
									receiveData.length);
							datagramSocket.receive(receivePacket);
							String message = new String(receivePacket.getData());
							System.out.println(message);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
