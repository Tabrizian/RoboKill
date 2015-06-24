package game.cells;

import game.Position;
import game.objects.Box;
import game.objects.Thing;
import game.objects.Wall;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Cell {

	protected Thing thing;
	protected Position pos;
	protected boolean isExploded;
	protected Image image ;
	
	
	public Cell(float xPos , float yPos , Thing thing ){
		isExploded = false ;
		pos = new Position(xPos, yPos) ;
		if( thing instanceof Box ){
			this.thing = new Box() ;
			this.thing = thing ;
		}
		else if( thing instanceof Wall ){
			this.thing = new Wall() ;
			this.thing = thing ;			
		}
	}
	
	public Cell(float xPos , float yPos){
		isExploded = false ;
		pos = new Position(xPos, yPos) ;
	}
	/**
	 * Getter for position of the cell on screen
	 * @return pos
	 */
	public Position getPos(){
		return pos ;
	}
	/**
	 * Setter for position of the cell on screen
	 * @param pos
	 */
	public void setPos( Position pos ){
		this.pos = pos ;
	}
	/**
	 * Add a thing to cell
	 * @param thing
	 */
	public void setThing( Thing thing ){
		this.thing = thing ;
	}
	/**
	 * Draw the cell behind its thing if exists
	 */
	public  void draw(){
		image.draw(pos.getX(), pos.getY());
		if( thing != null )
			thing.draw() ;
		
	}
	/**
	 * Loads images
	 */
	public  void init(){
		try {
			image = new Image("pics/cells/image 831.png") ;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if( thing != null )
			thing.init() ;
			
	}
}
