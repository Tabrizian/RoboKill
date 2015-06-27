package game.objects.weapons;

import game.Position;

import org.newdawn.slick.GameContainer;

public abstract class ShotgunMissile extends Missile {

	// place of missile in a one shot(ordered from left to right)
	private int num;

	public ShotgunMissile(float angle, Position pos, int num, String owner) {
		super(angle, pos, owner);
		// TODO Auto-generated constructor stub
		this.num = num;
	}

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
		if (num == 0) {
			pos.setX(pos.getX() + (float) Math.cos(angle - Math.PI / 24));
			pos.setY(pos.getY() + (float) Math.sin(angle - Math.PI / 24));
		} else if (num == 1) {
			pos.setX(pos.getX() + (float) Math.cos(angle - Math.PI / 48));
			pos.setY(pos.getY() + (float) Math.sin(angle - Math.PI / 48));
		} else if (num == 2) {
			pos.setX(pos.getX() + (float) Math.cos(angle + Math.PI / 48));
			pos.setY(pos.getY() + (float) Math.sin(angle + Math.PI / 48));
		} else if (num == 3) {
			pos.setX(pos.getX() + (float) Math.cos(angle + Math.PI / 24));
			pos.setY(pos.getY() + (float) Math.sin(angle + Math.PI / 24));
		}
	}
}
