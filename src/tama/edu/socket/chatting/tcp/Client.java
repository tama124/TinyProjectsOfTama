package tama.edu.socket.chatting.tcp;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			System.out.println("Client 1");
			Socket socket = new Socket("127.0.0.1", 6789);
			
			Scanner scInput = new Scanner(System.in);
			
			Scanner sc = new Scanner(socket.getInputStream());
			PrintStream ps = new PrintStream(socket.getOutputStream());

			// receiving thread
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						String nhan = sc.nextLine();
						System.out.println(nhan);
					}
				}
			}).start();

			// sending thread
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						String gui = scInput.nextLine();
						ps.println(gui);
					}
				}
			}).start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
