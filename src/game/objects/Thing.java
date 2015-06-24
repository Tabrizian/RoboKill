package game.objects;

import org.newdawn.slick.Image;

public abstract class Thing {
	/**
	 * Image of the thing in field
	 */
	protected Image image ;
	
	public Thing(){
		
	}
	/**
	 * Draw image
	 */
	public abstract void draw(float xPos , float yPos) ;
	/**
	 * Loads image
	 */
	public abstract void init() ;

}
