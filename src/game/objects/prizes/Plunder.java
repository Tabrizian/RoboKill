package game.objects.prizes;

import game.Position;
import game.objects.AddOne;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

public abstract class Plunder extends AddOne{
	
	protected Image image ;
	protected Position pos ;
	
	public Plunder(Position pos){
		this.pos = pos ;
	}
	public Plunder(){
		
	}
	public void setPos( Position pos ){
		this.pos = new Position(pos) ;
	}
	public Position getPos(){
		return pos;
	}
	public abstract void draw() ;
	
	public abstract void init() ;
	public abstract void update(GameContainer gc ) ;

}
