package game.objects.weapons;

import game.Position;

import java.awt.Point;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

public abstract class Weapon {
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
	protected Image imageInInventory;
	protected Image imageInField;
	
	protected String imageInInventoryAddress ;
	protected String imageInFieldAddress ;
	
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
	public String getImageInInventoryAddress() {
		return imageInInventoryAddress;
	}

	/**
	 * Getter for image of weapon in game field
	 * 
	 * @return Image address that is in game field
	 */
	public String getImageInFieldAddress() {
		return imageInFieldAddress;
	}
	
	public abstract void shot(float angleRad , Position pos ) ;
	public abstract void init() ;
	public abstract void update(GameContainer gc);
	public abstract void draw() ;
}
