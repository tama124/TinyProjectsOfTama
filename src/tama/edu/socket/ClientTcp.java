package tama.edu.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTcp {
	public static void main(String[] args) {
	}
	
	public void simpleStringSocket() {
		try {
			Socket socket = new Socket("127.0.0.1", 6789);

			Scanner inputFromKeyboard = new Scanner(System.in);
			String inputMessage = inputFromKeyboard.nextLine();

			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println(inputMessage);

			Scanner sc = new Scanner(socket.getInputStream());
			String message = sc.next();
			
			System.out.println("Received from server : " + message);

			sc.close();
			inputFromKeyboard.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void simpleObjectSocket() {
		try {
			Socket socket = new Socket("127.0.0.1", 6789);

			BasicObjectDemo s1 = new BasicObjectDemo("001", "Buu");
			BasicObjectDemo s2 = new BasicObjectDemo("002", "Loan");
			BasicObjectDemo s3 = new BasicObjectDemo("003", "Tam");

			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(s1);
			oos.writeObject(s2);
			oos.writeObject(s3);

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			BasicObjectDemo ss1 = (BasicObjectDemo) ois.readObject();
			BasicObjectDemo ss2 = (BasicObjectDemo) ois.readObject();
			BasicObjectDemo ss3 = (BasicObjectDemo) ois.readObject();
			System.out.println("Received from server : " + ss1);
			System.out.println("Received from server : " + ss2);
			System.out.println("Received from server : " + ss3);
			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendStringFromFile() {
		try {
			// socket client
			Socket socket = new Socket("127.0.0.1", 6789);
			// scanner to read file
			Scanner fileScanner = new Scanner(new FileInputStream(new File("files/messages_client.txt")));
			// printer to write file
			PrintStream filePrinter = new PrintStream(new File("files/messages_server.txt"));
			// print stream to send message
			PrintStream ps = new PrintStream(socket.getOutputStream());
			// scanner to receive message
			Scanner sc = new Scanner(socket.getInputStream());
			// this is message is sent
			String message;
			// read all lines in file and send them to server
			while (fileScanner.hasNextLine()) {
				message = fileScanner.nextLine();
				ps.println(message);
			}
			// receive all messages from server, print to screen and write them to file
			while (sc.hasNextLine()) {
				message = sc.nextLine();
				System.out.println(message);
				filePrinter.println(message);
			}
			// close stream
			socket.close();
			fileScanner.close();
			filePrinter.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void giaiPhuongTrinhBacNhat() {
		try {
			// receive a, b, c from user
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap a: ");
			int a = sc.nextInt();
			System.out.println("Nhap b: ");
			int b = sc.nextInt();
			System.out.println("Nhap c: ");
			int c = sc.nextInt();

			// create socket and send the numbers to server
			Socket socket = new Socket("127.0.0.1", 6789);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeInt(a);
			dos.writeInt(b);
			dos.writeInt(c);

			// receive the numbers from server
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			float x = dis.readFloat();
			float x1 = dis.readFloat();
			float x2 = dis.readFloat();
			int flag = dis.readInt();
			if (flag == 1) {
				System.out.println("Phuong trinh vo so nghiem.");
			} else if (flag == 2) {
				System.out.println("Phuong trinh vo nghiem.");
			} else if (flag == 3) {
				System.out.println("Phuong trinh co nghiem duy nhat : " + x);
			} else if (flag == 4) {
				System.out.println("Phuong trinh co hai nghiem phan biet : " + x1 + " va " + x2);
			}

			// close stream
			socket.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
