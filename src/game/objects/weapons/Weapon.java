package game.objects.weapons;

import game.Position;
import game.objects.AddOne;
import game.objects.Robot;

import java.awt.Point;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

public abstract class Weapon extends AddOne {
	// Controls rendering for missiles
	protected long renderControler = 0;
	/**
	 * Properties
	 */
	protected int power;
	//Lower is faster
	protected float speedRate;
	protected int price;
	protected String name;
	/**
	 * Mouse Point
	 */
	protected Point mousePoint;
	/**
	 * Place in robot.(-1 if is not used by robot )
	 */
	protected int place = -1;

	protected ArrayList<Missile> missiles;
	
	public Weapon(int place) {
		this.place = place;
		missiles = new ArrayList<Missile>();
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
	public float getSpeedRate() {
		float x = (float) (1/speedRate*45) ;
		x *= 100 ;
		x = (int)x ;
		x /= 100 ;
		return x ;
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

	public void setPlace( int index ){
		place = index ;
	}
	/**
	 * Add a gun to robot in Specified place
	 * 
	 * @param place
	 *            Specified place in robot
	 * @param robot
	 *            Gun add to this robot
	 */
	public void addGunToRobot(int place, Robot robot) {

	}

	public abstract void shot(float angleRad, Position pos, int robotWidth );
	public abstract void init();

	public  void update(GameContainer gc){

		// TODO Auto-generated method stub
		for (int i = 0; i < missiles.size(); i++) {
			Missile missile2 =  missiles.get(i);
			if (missile2.getPos().getX() < 800 && missile2.getPos().getX() > 0
					&& missile2.getPos().getY() > 0
					&& missile2.getPos().getY() < 600) {
				missile2.update(gc);
			} else {
				missiles.remove(i);
			}
		}
	
	}
	public  void draw(){

		// TODO Auto-generated method stub
		for (Missile missile2 : missiles) {
			if (missile2 != null)
				missile2.draw();
		}
	
	}
}
