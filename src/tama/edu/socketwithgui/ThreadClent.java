package tama.edu.socketwithgui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadClent implements Runnable {
	private Socket socket;

	public ThreadClent(Socket sock) {
		socket = sock;
	}

	public void sendMessage(String msg) throws Exception {
		for (int i = 0; i < Server.mClient.size(); i++) {
			PrintWriter pr = new PrintWriter(Server.mClient.getClient(i)
					.getOutputStream(), true);
			pr.println(msg);
		}
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			while (true) {
				String msg = br.readLine();
				sendMessage(msg);
			}
		} catch (Exception e) {
		}
	}

}
