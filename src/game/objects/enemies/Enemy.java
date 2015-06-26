package game.objects.enemies;

import game.Position;
import game.objects.weapons.Weapon;

import java.util.ArrayList;

import javax.swing.JComponent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

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
	
	public void draw(){
		
	}
	
	public void update(GameContainer gc){
		
	}
	
	public void setRobotPos( Position pos) {
		
	}
}
