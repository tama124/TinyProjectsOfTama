package tama.edu.socket.chatting.gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecieveMessage implements Runnable {
	private Socket socket;

	public RecieveMessage(Socket sock) {
		socket = sock;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			while (true) {
				Gui.jtaMsg.setText(Gui.jtaMsg.getText() + br.readLine() + "\n");
			}
		} catch (Exception e) {
		}

	}
}
