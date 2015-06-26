package game.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Barrel extends Thing {

	/**
	 * kind of the box based on its rotation ;
	 */
	private int kind ;
	
	public Barrel() {
		// TODO Auto-generated constructor stub
		kind = 3 ;
		init() ;
	}
	public Barrel(int kind) {
		// TODO Auto-generated constructor stub
		this.kind = kind ;
		init() ;
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			image = new Image("pics/things/image 500" + kind + ".png") ;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
