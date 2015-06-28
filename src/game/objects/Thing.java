package game.objects;

import game.objects.weapons.MissilesDatabase;

import org.newdawn.slick.Image;

public abstract class Thing {
	/**
	 * Image of the thing in field
	 */
	protected Image image;
	private int health = 100;

	public Thing() {

	}

	/**
	 * Draw image
	 */
	public void draw(float xPos, float yPos) {
		image.drawCentered(xPos + 29 , yPos + 29);
	}

	/**
	 * Loads image
	 */
	public abstract void init();

	public int getHealth() {
		return health;
	}

	public void decHealth() {
		health--;
	}

}
