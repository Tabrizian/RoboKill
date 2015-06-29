package game.communcation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Message {
	public static final String INIT = "init"; 
	public static final String UPDATE = "update";
	private String text;
	private String header;
	
	public Message(String text, String header){
		this.text = text;
		this.header = header;
	}
	
	public void send(Socket client){
		OutputStream out = null;
		try {
			out = client.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(out);
		pw.println(text);
		pw.println(header);
	}
	
	
}
