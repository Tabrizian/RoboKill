package game.objects.weapons;

import game.Position;

import org.newdawn.slick.GameContainer;

public abstract class BlasterMissile extends Missile {

	public BlasterMissile(float angle, Position pos, String owner, int damage) {
		super(angle, pos, owner, damage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initialize missile
	 */
	public void draw() {
		if (isExploded() == false) {
			img.setRotation((float) (angle * 180 / Math.PI - 90));
			img.drawCentered(pos.getX(), pos.getY());
		}

	}

	/**
	 * Updates position of missile.
	 * 
	 * @param gc
	 */
	public void update(GameContainer gc) {
		pos.setX(pos.getX() + (float) Math.cos(angle));
		pos.setY(pos.getY() + (float) Math.sin(angle));
	}

}
