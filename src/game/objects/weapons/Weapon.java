package game.objects.weapons;

import java.awt.Point;

public class Weapon {
	/**
	 * Properties
	 */
	protected int power;
	protected float speed;
	protected int price;
	protected String name;
	/**
	 * Mouse Point
	 */
	protected Point mousePoint;
	/**
	 * Image of weapon
	 */
	protected String imageInInventory;
	protected String imageInField;

	public Weapon() {

	}

	/**
	 * Getter for power
	 * 
	 * @return power of weapon
	 */
	public int getPower() {
		return power;
	}

	/**
	 * Getter for speed
	 * 
	 * @return speed of weapon
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * Getter for price
	 * 
	 * @return price of weapon
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Getter for name
	 * 
	 * @return name of weapon
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for mouse point
	 * 
	 * @param p
	 */
	public void setMousePoint(Point p) {
		mousePoint = p;
	}

	/**
	 * Getter for mouse point
	 * 
	 * @return Mouse point
	 */
	public Point getMousePoint() {
		return mousePoint;
	}

	/**
	 * Getter for image of weapon in inventory
	 * 
	 * @return Image address that is in inventory
	 */
	public String getImageInInventory() {
		return imageInInventory;
	}

	/**
	 * Getter for image of weapon in game field
	 * 
	 * @return Image address that is in game field
	 */
	public String getImageInField() {
		return imageInField;
	}
	
}
