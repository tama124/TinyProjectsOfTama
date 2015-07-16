package tama.edu.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUdp {
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket();

			byte[] sendData = new byte[1024];
			sendData = new String("abc").getBytes();
			InetAddress ipAddress = InetAddress.getByName("localhost");
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, ipAddress, 6789);
			datagramSocket.send(sendPacket);

			byte[] receiveData = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			datagramSocket.receive(receivePacket);
			String message = new String(receivePacket.getData());
			System.out.println("Received from server: " + message);

			datagramSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
