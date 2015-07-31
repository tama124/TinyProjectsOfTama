package tama.edu.socket.chatting.tcp;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(6789);
			System.out.println("Started");
			Socket socket1 = serverSocket.accept();
			System.out.println("Client 1 connected");
			Socket socket2 = serverSocket.accept();
			System.out.println("Client 2 connected");

			Scanner sc1 = new Scanner(socket1.getInputStream());
			PrintStream ps1 = new PrintStream(socket1.getOutputStream());
			Scanner sc2 = new Scanner(socket2.getInputStream());
			PrintStream ps2 = new PrintStream(socket2.getOutputStream());

			// 1 -> 2
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						String m = sc1.nextLine();
						ps2.println(m);
					}
				}
			}).start();

			// 2 -> 1
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						String m = sc2.nextLine();
						ps1.println(m);
					}
				}
			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
