package tama.edu.socket.chatting.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Gui extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 400;
	private final int HEIGHT = 300;
	public static JTextArea jtaMsg;
	private JTextField jtfText;
	private JButton jbtSend;
	private Socket socket;
	PrintWriter pr;

	public Gui() {
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		try {
			socket = new Socket("localhost", 9999);
			pr = new PrintWriter(socket.getOutputStream(), true);
		} catch (Exception e) {
		}
		onCreate();
		new Thread(new RecieveMessage(socket)).start();
	}

	private void onCreate() {
		JPanel jpnNorth = new JPanel();
		jpnNorth.setLayout(new BorderLayout());
		jpnNorth.setBorder(BorderFactory.createTitledBorder("Message"));
		jpnNorth.setPreferredSize(new Dimension(WIDTH, 300));
		jtaMsg = new JTextArea(20, 10);
		jpnNorth.add(new JScrollPane(jtaMsg));

		JPanel jpnSound = new JPanel();
		jpnSound.setLayout(new FlowLayout(FlowLayout.CENTER));
		jtfText = new JTextField();
		jtfText.setPreferredSize(new Dimension(311, 27));
		jbtSend = new JButton("Send");
		jpnSound.add(jtfText);
		jpnSound.add(jbtSend);
		this.add(jpnNorth, BorderLayout.CENTER);
		this.add(jpnSound, BorderLayout.SOUTH);

		jbtSend.addActionListener(this);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Gui().setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtSend) {
			pr.println(jtfText.getText());
			jtfText.setText("");
		}
	}
}
