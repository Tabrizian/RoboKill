package game.objects.enemies;

import game.Position;
import game.objects.prizes.Plunder;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Enemy {

	protected Position pos;
	protected int health;
	protected Position robotPosition;
	protected Plunder plunder;
	protected int destroyedDamage;

	public Enemy() {

	}

	/**
	 * get robot position
	 * 
	 * @return
	 */
	public Position getPos() {
		return pos;
	}

	public void init() {

	}

	public void draw(Graphics g) {

	}

	public void update(GameContainer gc) {

	}

	public void setRobotPos(Position pos) {

	}

	public int getHealth() {
		return health;
	}

	public Plunder getPlunder() {
		return plunder;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDestroyDamage() {
		return destroyedDamage;
	}
}
