package game.objects.weapons;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.Position;

public abstract  class BlasterMissile extends Missile {

	public BlasterMissile(float angle, Position pos,String owner) {
		super(angle, pos,owner);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initialize missile
	 */
	public void draw() {
		img.setRotation((float) (angle*180/Math.PI - 90 ));
		img.drawCentered(pos.getX(), pos.getY());
		
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
