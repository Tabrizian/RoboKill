package game.cells;

import game.Position;
import game.objects.Thing;

public abstract class Cell {

	private Thing thing;
	private Position pos;
	private boolean isExploded;
	
	public Cell(float xPos , float yPos , Thing thing ){
		isExploded = false ;
		pos = new Position(xPos, yPos) ;
		this.thing = new Thing() ;
		this.thing = thing ;
	}
	
	public Cell(float xPos , float yPos){
		isExploded = false ;
		pos = new Position(xPos, yPos) ;
	}
	
	public Position getPos(){
		return pos ;
	}
	
	public void setPos( Position pos ){
		this.pos = pos ;
	}
	
	public void setThing( Thing thing ){
		this.thing = thing ;
	}
	
	public abstract void draw() ;
	public abstract void init() ;
}
