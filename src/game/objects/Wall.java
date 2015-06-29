package game.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Wall extends Thing {

	public Wall() {
		init();
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			image = new Image("pics/things/image 198.png") ;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void decHealth(){
		
	}
	
	@Override
	public void setHealth(int health) {
		
	}
}
