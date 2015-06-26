package game.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Box extends Thing {

	/**
	 * kind of the box based on its rotation ;
	 */
	private int kind ;
	public Box() {
		// TODO Auto-generated constructor stub
		kind = 1 ;
		init();
	}

	public Box( int kind ){
		this.kind = kind ;
		init();
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			image = new Image("pics/things/image 712" + kind + ".png") ;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
