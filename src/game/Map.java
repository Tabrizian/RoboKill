package game;

import game.objects.Robot;

public class Map {

	/**
	 * Rooms
	 */
	private GameField[][] fields ;
	/**
	 * The robot
	 */
	private Robot robot ;
	/**
	 * Player who controls robot
	 */
	private Player player ;
	/**
	 * An instance of the map
	 */
	private static Map instance ;
	
	private Map(){
		instance = this ;
	}
	/**
	 * A method that return a unique map
	 * @return
	 */
	public static Map getMap(){
		if( instance == null )
			new Map() ;
		return instance ;
	}
	
	public void init(){
		
	}
	
	public void draw(){
		
	}
	
	public void update(){
		
	}
	
	public void drawInScopeMode(){
		
	}
}
