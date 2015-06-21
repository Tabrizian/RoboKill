package game.objects;

import game.Position;
import game.objects.weapons.Missile;
import game.objects.weapons.Weapon;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * This is a Robot!
 * 
 * @author mahdi
 *
 */
public class Robot {

	/**
	 * Position of robot
	 */
	private Position pos;
	/**
	 * Weapons that robot carries them
	 */
	private ArrayList<Weapon> weapons;
	/**
	 * Healthy of robot
	 */
	private int health;
	/**
	 * Robot angle
	 */
	private float imageAngleRad = 0;
	private float imageAngleDeg = 0;
	/**
	 * mouse point
	 */
	private Point mousePoint;
	/**
	 * ArrayList of current missiles.
	 */

	private ArrayList<Missile> missiles;

	private String imageOfBodyAddress;
	private String imageOfLegAddress;

	private Image imageOfBody;
	private Image imageOfLeg;

	public Robot() {
		super();

		missiles = new ArrayList<Missile>();

		pos = new Position(70, 70);
		weapons = new ArrayList<Weapon>();
		health = 100;

		imageOfBodyAddress = ("pics/robot/image 286.png");
		imageOfLegAddress = ("pics/robot/image 123.png");

	}

	/**
	 * set mouse point
	 * 
	 * @param p
	 */
	public void setMousePoint(Point p) {
		mousePoint = p;
	}

	/**
	 * get robot position
	 * 
	 * @return
	 */
	public Position getPos() {
		return pos;
	}

	/**
	 * Set an angle for robot rotating
	 * 
	 * @param r
	 */
	public void setImageAngle(float r) {
		imageAngleRad = r;
	}

	public String getImageOfBody() {
		return imageOfBodyAddress;
	}

	public String getImageOfLeg() {
		return imageOfLegAddress;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	/**
	 * Loads image of robot
	 */
	public void init() {
		try {
			imageOfLeg = new Image(this.getImageOfLeg());
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			imageOfBody = new Image(this.getImageOfBody());
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Draw robot with an angle for rotating that based on mouse position
	 * 
	 * @param angle
	 */
	public void draw() {
		imageOfLeg.draw(this.getPos().getX(), this.getPos().getY());
		imageOfBody.setRotation(imageAngleDeg);
		imageOfBody.draw(this.getPos().getX(), this.getPos().getY());

		
		for( Weapon gun : weapons ){
			gun.draw() ;

		}
		
	}

	/**
	 * Updates robot state in GameContainer gc
	 * 
	 * @param gc
	 */
	public void update(GameContainer gc) {
		float xPos = this.getPos().getX();
		float yPos = this.getPos().getY();

		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(input.KEY_W)) {
			yPos -= 0.25;
		}
		if (input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(input.KEY_S)) {
			yPos += 0.25;
		}
		if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(input.KEY_D)) {
			xPos += 0.25;
		}
		if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(input.KEY_A)) {
			xPos -= 0.25;
		}

		this.setPos(new Position(xPos, yPos));

		double dx = input.getMouseX() - this.getPos().getX();
		double dy = input.getMouseY() - this.getPos().getY();
		imageAngleRad = (float) (Math.atan2(dy, dx) - Math.PI / 2);

		imageAngleDeg = (float) (imageAngleRad * 180 / Math.PI);

		if (input.isMouseButtonDown(0))
				fire();
		
		for( Weapon gun : weapons ){
			gun.update(gc) ;
		}

	}

	/**
	 * Fires missiles
	 */
	public void fire() {
		
		for ( Weapon gun : weapons ){
			gun.shot( imageAngleRad , pos );
		}
	}
	/**
	 * Add a gun to robot
	 * @param gun
	 */
	public void addGun( Weapon gun ){
		weapons.add(gun) ;
	}
	
	public void remGun(){
	}
}
