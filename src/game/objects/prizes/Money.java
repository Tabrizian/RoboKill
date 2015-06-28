package game.objects.prizes;

import game.Position;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Money extends Plunder {

	
	public Money(Position pos){
		super(pos) ;
		init() ;
	}
	public Money(){
		super() ;
		init() ;
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			image = new Image("pics/plunder/image 175.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw(){
		// TODO Auto-generated method stub
		image.drawCentered(pos.getX(), pos.getY());
	}
	
	@Override
	public void update(GameContainer gc) {
		// TODO Auto-generated method stub
		
	}

}
