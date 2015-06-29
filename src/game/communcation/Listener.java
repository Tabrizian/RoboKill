package game.communcation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Vector;

public class Listener implements Runnable {

	private Socket socket;
	private Vector<Message> messages;

	public Listener(Socket socket) {
		this.socket = socket;
		messages = new Vector<Message>();
	}

	@Override
	public void run() {
		try {
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			while (true) {
				String header = br.readLine();
				String text = br.readLine();
				messages.add(new Message(text, header));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Vector<Message> getMessages() {
		return messages;
	}

}
