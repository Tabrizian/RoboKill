package game.objects.weapons;

import game.Position;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Missile {
	protected Position pos;
	protected Image img;
	/**
	 * Angle at which missile is shooted.
	 */
	protected float angle;

	public Missile(float angle, Position pos) {
		this.angle = angle;
		this.pos = new Position(pos);
		init();
	}

	public Position getPos() {
		return pos;
	}

	/**
	 * Initialize missile
	 */
	public abstract void init();

	public abstract void draw();

	/**
	 * Updates position of missile.
	 * 
	 * @param gc
	 */
	public abstract void update(GameContainer gc);

}
