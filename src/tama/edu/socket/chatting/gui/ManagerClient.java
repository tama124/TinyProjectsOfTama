package tama.edu.socket.chatting.gui;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ManagerClient {
	private List<Socket> clients;

	public ManagerClient() {
		clients = new ArrayList<Socket>();
	}

	public boolean addClient(Socket sock) {
		if (!clients.contains(sock))
			return clients.add(sock);
		return false;
	}

	public void removeClient(Socket sock) {
		clients.remove(sock);
	}

	public Socket getClient(int index) {
		if (index < clients.size() && index >= 0)
			return clients.get(index);
		return null;
	}

	public int size() {
		return clients.size();
	}
}
