package game.objects;

import game.Game;
import game.Position;
import game.objects.weapons.Weapon;

import java.awt.Point;
import java.util.ArrayList;

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
	/**
	 * mouse point
	 */
	private Point mousePoint;

	private String imageOfBodyAddress;
	private String imageOfLegAddress;

	private Image imageOfBody;
	private Image imageOfLeg;

	// Screen size
	// private int width = (int) getToolkit().getScreenSize().getWidth();
	// private int height = (int) getToolkit().getScreenSize().getHeight();

	public Robot() {
		super();

		pos = new Position(70, 70);
		// weapons = new ArrayList<Weapon>();
		health = 100;

		imageOfBodyAddress = ("src/game/images/robot/image 286.png");
		imageOfLegAddress = ("src/game/images/robot/image 123.png");

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
	 * Load image of robot
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
		imageOfBody.setRotation(imageAngleRad);
		imageOfBody.draw(this.getPos().getX(), this.getPos().getY());
	}
	/**
	 * Updates robot state in GameContainer gc
	 * @param gc
	 */
	public void update(GameContainer gc){
		float xPos = this.getPos().getX();
		float yPos = this.getPos().getY();
		
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_UP)) {
			yPos -= 0.25;
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			yPos += 0.25;
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			xPos += 0.25;
		}
		if (input.isKeyDown(Input.KEY_LEFT)) {
			xPos -= 0.25;
		}
		
		this.setPos(new Position(xPos, yPos));
		
		double dx = input.getMouseX() - this.getPos().getX();
		double dy = input.getMouseY() - this.getPos().getY();
		imageAngleRad = (float) (Math.atan2(dy, dx) - Math.PI / 2);
		imageAngleRad = (float) (imageAngleRad * 180 / Math.PI);
	}
}
