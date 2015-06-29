package game.objects.prizes.guns;

import game.Position;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LightGun extends Gun {

	public LightGun(Position pos){
		super(pos) ;
		init() ;
	}
	public LightGun(){
		super() ;
		init() ;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		image.drawCentered(pos.getX(), pos.getY());
	
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			image = new Image("pics/plunder/3.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(GameContainer gc) {
		// TODO Auto-generated method stub
		
	}

}
