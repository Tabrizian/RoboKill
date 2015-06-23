package game.objects;

import game.Position;
import game.objects.weapons.Missile;
import game.objects.weapons.Weapon;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.KeyListener;
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
	private String imageOfBodyAddress;
	private String imageOfLegAddress;

	private Image imageOfBody;
	private Image imageOfLeg;

	/**
	 * Place for add a gun that ordered from left to right
	 */
	private int[] places = { 0, 0, 0, 0 };

	private Animation toUp;
	private boolean iskeyUpPressed = false;

	private Animation fixState;

	private Animation toDown;
	private boolean iskeyDownPressed = false;

	public Robot() {
		super();

		pos = new Position(70, 70);
		weapons = new ArrayList<Weapon>();
		health = 100;

		imageOfBodyAddress = ("pics/robot/image" + " " + places[0] + places[1]
				+ places[2] + places[3] + ".png");
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

		toUp = new Animation(createToUpFrames(), 150);
		fixState = new Animation(createFixStateFrame(), 150);
		toDown = new Animation(createToDownFrames(), 150) ;
	}

	/**
	 * Draw robot with an angle for rotating that based on mouse position
	 * 
	 * @param angle
	 */
	public void draw() {

		imageOfBody.setRotation(imageAngleDeg);
		imageOfBody.drawCentered(pos.getX(), pos.getY());

		for (Weapon gun : weapons) {
			gun.draw();

		}

		if (iskeyUpPressed == true) {

			fixState.stop();
			toUp.draw(pos.getX() - imageOfBody.getWidth() / 2, pos.getY()
					- imageOfBody.getHeight() / 2);
			toUp.start();
			imageOfBody.setRotation(imageAngleDeg);
			imageOfBody.drawCentered(pos.getX(), pos.getY());
		}

	/*	else if (iskeyDownPressed == true) {

			fixState.stop();
			toDown.draw(pos.getX() - imageOfBody.getWidth() / 2, pos.getY()
					- imageOfBody.getHeight() / 2);
			toDown.start();
			imageOfBody.setRotation(imageAngleDeg);
			imageOfBody.drawCentered(pos.getX(), pos.getY());
		}
		*/
		if (iskeyUpPressed == false) {
			toUp.stop();
			fixState.draw(pos.getX() - imageOfBody.getWidth() / 2, pos.getY()
					- imageOfBody.getHeight() / 2);
			imageOfBody.setRotation(imageAngleDeg);
			imageOfBody.drawCentered(pos.getX(), pos.getY());
		}
/*
		else if (iskeyDownPressed == false) {
			toDown.stop();
			fixState.draw(pos.getX() - imageOfBody.getWidth() / 2, pos.getY()
					- imageOfBody.getHeight() / 2);
			imageOfBody.setRotation(imageAngleDeg);
			imageOfBody.drawCentered(pos.getX(), pos.getY());
		}*/

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
			iskeyUpPressed = true;
		} else
			iskeyUpPressed = false;
		if (input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(input.KEY_S)) {
			yPos += 0.25;
			iskeyDownPressed = true;
		} else
			iskeyDownPressed = false;
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

		for (Weapon gun : weapons) {
			gun.update(gc);
		}

	}

	/**
	 * Fires missiles
	 */
	public void fire() {

		for (Weapon gun : weapons) {
			gun.shot(imageAngleRad, pos, imageOfBody.getWidth() * 70 / 100);
		}
	}

	/**
	 * Add a gun to robot in specified place
	 * 
	 * @param gun
	 * @param place
	 */
	public void addGun(Weapon gun, int place) {
		weapons.add(gun);
		places[place] = 1;
		imageOfBodyAddress = ("pics/robot/image" + " " + places[0] + places[1]
				+ places[2] + places[3] + ".png");
		// Destroy previous image of body
		try {
			imageOfBody.destroy();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Create new image of body
		try {
			imageOfBody = new Image(this.getImageOfBody());
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void remGun() {
	}

	private Image[] createToUpFrames() {
		Image[] frames = new Image[5];

		try {
			Image image1 = new Image("pics/robot/image 123.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image2 = new Image("pics/robot/image 231.png");
			frames[1] = image2;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image3 = new Image("pics/robot/image 485.png");
			frames[2] = image3;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image4 = new Image("pics/robot/image 653.png");
			frames[3] = image4;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image5 = new Image("pics/robot/image 589.png");
			frames[4] = image5;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;
	}

	private Image[] createFixStateFrame() {
		Image[] frames = new Image[1];

		try {
			Image image1 = new Image("pics/robot/image 123.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;
	}

	private Image[] createToDownFrames() {

		Image[] frames = new Image[5];

		try {
			Image image1 = new Image("pics/robot/image 123.png");
			frames[4] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image2 = new Image("pics/robot/image 231.png");
			frames[3] = image2;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image3 = new Image("pics/robot/image 485.png");
			frames[2] = image3;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image4 = new Image("pics/robot/image 653.png");
			frames[1] = image4;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image5 = new Image("pics/robot/image 589.png");
			frames[0] = image5;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;

	}
}
