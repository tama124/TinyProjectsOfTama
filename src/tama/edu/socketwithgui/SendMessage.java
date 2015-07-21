package tama.edu.socketwithgui;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendMessage implements Runnable {
	private Socket socket;

	public SendMessage(Socket sock) {
		socket = sock;
	}

	@Override
	public void run() {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				System.out.println();
				String msg = sc.nextLine();
				pr.println(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
