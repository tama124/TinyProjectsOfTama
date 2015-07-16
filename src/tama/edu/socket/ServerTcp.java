package tama.edu.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTcp {
	public static void main(String[] args) {
	}

	public void sendString() {
		try {
			ServerSocket serverSocket = new ServerSocket(6789);
			System.out.println("Server started. Waiting for client ...");
			Socket socket = serverSocket.accept();

			Scanner sc = new Scanner(socket.getInputStream());
			String message = sc.next();

			message = message.toUpperCase();

			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println(message);

			sc.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendObject() {
		try {
			ServerSocket serverSocket = new ServerSocket(6789);
			System.out.println("Server started. Waiting for client ...");
			Socket socket = serverSocket.accept();

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			BasicObjectDemo s1 = (BasicObjectDemo) ois.readObject();
			BasicObjectDemo s2 = (BasicObjectDemo) ois.readObject();
			BasicObjectDemo s3 = (BasicObjectDemo) ois.readObject();

			s1.setName(s1.getName().toUpperCase());
			s2.setName(s2.getName().toUpperCase());
			s3.setName(s3.getName().toUpperCase());

			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(s1);
			oos.writeObject(s2);
			oos.writeObject(s3);

			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendStringFromFile() {
		try {
			// create server socket and waiting for client
			ServerSocket serverSocket = new ServerSocket(6789);
			System.out.println("Server started. Waiting for client ...");
			Socket socket = serverSocket.accept();

			// create stream in and stream out
			Scanner sc = new Scanner(socket.getInputStream());
			PrintStream ps = new PrintStream(socket.getOutputStream());

			// read all message from client
			while (sc.hasNextLine()) {
				String message = sc.nextLine();
				message = message.toUpperCase();
				ps.println(message);
			}

			// close stream
			sc.close();
			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void giaiPhuongTrinhBacNhat() {
		try {
			// create server socket and waiting for client
			ServerSocket serverSocket = new ServerSocket(1234);
			System.out.println("Server started. Waiting for client ...");
			Socket socket = serverSocket.accept();

			// receive the numbers from client
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			int a = dis.readInt();
			int b = dis.readInt();
			int c = dis.readInt();

			// Giai phuong trinh
			int flag = 0;
			float x = 0;
			float x1 = 0;
			float x2 = 0;
			if (a == 0) {
				if (b == 0) {
					if (c == 0) {
						flag = 1;
					} else {
						flag = 2;
					}
				} else {
					flag = 3;
					x = (float) (-c / b);
				}
			} else {
				float delta = (b * b) - 4 * (a * c);
				if (delta < 0) {
					flag = 2;
				} else {
					if (delta == 0) {
						flag = 3;
						x = (float) (-b / (2 * a));
					} else {
						flag = 4;
						x1 = (float) (-b + Math.sqrt(delta)) / (2 * a);
						x2 = (float) (-b - Math.sqrt(delta)) / (2 * a);
					}
				}
			}

			// send result to client
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeFloat(x);
			dos.writeFloat(x1);
			dos.writeFloat(x2);
			dos.writeInt(flag);

			// close stream
			socket.close();
			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
