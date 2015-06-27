package game.objects.enemies;

import game.Position;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Enemy  {

	protected Position pos;
	protected int health;
	protected Position robotPosition ;
	
	public Enemy(){
		
	}
	
	/**
	 * get robot position
	 * 
	 * @return
	 */
	public Position getPos() {
		return pos;
	}
	
	public void init(){
		
	}
	
	public void draw(Graphics g){
		
	}
	
	public void update(GameContainer gc){

	}
	
	public void setRobotPos( Position pos) {
		
	}
}
