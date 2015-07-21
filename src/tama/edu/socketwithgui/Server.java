package tama.edu.socketwithgui;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final ManagerClient mClient = new ManagerClient();

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9999);
		System.out.println("server is runnning...");
		boolean running = true;
		while (running) {
			Socket socket = server.accept();
			Server.mClient.addClient(socket);
			new Thread(new ThreadClent(socket)).start();
		}
		server.close();
	}
}
