package tama.edu.socket;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(6789);
			while (true) {
				Socket socket = serverSocket.accept();
				socket.close();
				serverSocket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
