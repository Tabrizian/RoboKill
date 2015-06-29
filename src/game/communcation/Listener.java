package game.communcation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Vector;

public class Listener implements Runnable {

	private Socket socket;

	public Listener(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			while (true) {
				String header = br.readLine();
				String text = br.readLine();
				Inbox inbox = Inbox.getInbox() ;
				inbox.addMessage(new Message(text, header));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
