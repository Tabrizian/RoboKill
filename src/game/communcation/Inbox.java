package game.communcation;

import java.util.ArrayList;

public class Inbox {

	private ArrayList<Message> messages ;
	private static Inbox instance ;
	
	private Inbox(){
		
	}
	
	public static Inbox	getInbox(){
		if( instance == null )
			instance = new Inbox() ;
		return instance ;
	}
	
	public void addMessage( Message m ){
		messages.add(m) ;
	}
	
	public void delMessage( Message m ){
		messages.remove(m) ;
	}
	
	public void delMessage( int index ){
		messages.remove(index) ;
	}
	
	public ArrayList<Message> getMessages(){
		return messages ;
	}
}
