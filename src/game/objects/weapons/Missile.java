package game.objects.weapons;

import game.Position;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Missile {
	protected Position pos;
	protected Image img;
	private String owner;
	private int damage;
	/**
	 * Angle at which missile is shooted.
	 */
	protected float angle;
	protected boolean exploded;

	public Missile(float angle, Position pos, String owner, int damage) {
		this.angle = angle;
		this.damage = damage;
		this.pos = new Position(pos);
		this.owner = owner;
		MissilesDatabase.getMissilesDatabase().addMissile(this);
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

	public boolean isExploded() {
		return exploded;
	}

	public void setExploded(boolean exploded) {
		this.exploded = exploded;
	}

	public String getOwner() {
		return owner;
	}
	
	public int getDamage(){
		return damage;
	}
}
