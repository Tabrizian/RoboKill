package game.communcation;

public class Message {
	public static final String INIT = "init"; 
	public static final String UPDATE = "update";
	private String text;
	private String header;
	
	public Message(String text, String header){
		this.text = text;
		this.header = header;
	}
	
	
}
