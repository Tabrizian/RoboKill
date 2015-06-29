package game;

import game.objects.Robot;

public class Player {

	private int cash = 0;
	private String name;
	private static Player instance ;

	private Player(){
		cash = 100 ;
		instance = this ;
	}
	
	public static Player getPlayer() {
		if (instance == null)
			instance = new Player();
		return instance;
	}
	
	public int getCash(){
		return cash ;
	}
	
	public void setCash(int x ){
		cash = x ;
	}
}
