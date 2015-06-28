package game.objects.prizes;

import game.objects.AddOne;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

public abstract class Plunder extends AddOne{
	
	protected Image image ;
	
	public Plunder(){
		
	}
	
	public abstract void init() ;
	public abstract void update(GameContainer gc ) ;
	public abstract void draw() ;

}
