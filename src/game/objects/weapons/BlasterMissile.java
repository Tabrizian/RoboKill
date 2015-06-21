package game.objects.weapons;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.Position;

public class BlasterMissile extends Missile {

	public BlasterMissile(float angle, Position pos) {
		super(angle, pos);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initialize missile
	 */
	public void init() {
		try {
			img = new Image("src/game/images/fires/image 233.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw() {
		img.setRotation((float) (angle*180/Math.PI - 90 ));
		img.draw(pos.getX(), pos.getY());
		
	}

	/**
	 * Updates position of missile.
	 * @param gc
	 */
	public void update(GameContainer gc){
		pos.setX(pos.getX() + (float) Math.cos(angle));
		pos.setY(pos.getY() + (float) Math.sin(angle));
	}
}
