package game.objects.prizes;

import game.Position;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PlunderPack extends Plunder {

	public PlunderPack() {
		// TODO Auto-generated constructor stub
		super() ;
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			image = new Image("pics/plunder/image 553.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(GameContainer gc) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
