package tama.edu.socket.chatting.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter port for client 1: ");
			int port1 = sc.nextInt();
			System.out.println("Enter port for client 2: ");
			int port2 = sc.nextInt();
			
			System.out.println("Started.");
			
			final DatagramSocket datagramSocket_1 = new DatagramSocket(port1);

			byte[] receiveData_1 = new byte[1024];
			DatagramPacket receivePacket_1 = new DatagramPacket(
					receiveData_1, receiveData_1.length);
			datagramSocket_1.receive(receivePacket_1);
			final InetAddress ipAddress_1 = receivePacket_1
					.getAddress();
			final int port_1 = receivePacket_1.getPort();
			
			System.out.println("Client 1 connected.");
			
			final DatagramSocket datagramSocket_2 = new DatagramSocket(port2);

			byte[] receiveData_2 = new byte[1024];
			DatagramPacket receivePacket_2 = new DatagramPacket(
					receiveData_2, receiveData_2.length);
			datagramSocket_2.receive(receivePacket_2);
			final InetAddress ipAddress_2 = receivePacket_2
					.getAddress();
			final int port_2 = receivePacket_2.getPort();
			
			System.out.println("Client 2 connected.");
			
			// 1 -> 2
			new Thread(new Runnable() {

				public void run() {
					while (true) {
						try {
							byte[] receiveData_1 = new byte[1024];
							DatagramPacket receivePacket_1 = new DatagramPacket(
									receiveData_1, receiveData_1.length);
							datagramSocket_1.receive(receivePacket_1);
							String message_1 = new String(receivePacket_1
									.getData());

							byte[] sendData_2 = new byte[1024];
							sendData_2 = message_1.getBytes();
							DatagramPacket sendPacket_2 = new DatagramPacket(
									sendData_2, sendData_2.length, ipAddress_2,
									port_2);
							datagramSocket_2.send(sendPacket_2);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

			}).start();

			// 2 -> 1
			new Thread(new Runnable() {

				public void run() {
					while (true) {
						try {
							byte[] receiveData_2 = new byte[1024];
							DatagramPacket receivePacket_2 = new DatagramPacket(
									receiveData_2, receiveData_2.length);
							datagramSocket_2.receive(receivePacket_2);
							String message_2 = new String(receivePacket_2
									.getData());

							byte[] sendData_1 = new byte[1024];
							sendData_1 = message_2.getBytes();
							DatagramPacket sendPacket_1 = new DatagramPacket(
									sendData_1, sendData_1.length, ipAddress_1,
									port_1);
							datagramSocket_1.send(sendPacket_1);
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
