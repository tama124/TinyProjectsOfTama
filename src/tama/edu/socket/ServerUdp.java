package tama.edu.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUdp {
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(6789);

			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];

			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				datagramSocket.receive(receivePacket);
				String message = new String(receivePacket.getData());
				InetAddress ipAddress = receivePacket.getAddress();
				int port = receivePacket.getPort();

				message = message.toUpperCase();

				sendData = message.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
				datagramSocket.send(sendPacket);

				datagramSocket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
