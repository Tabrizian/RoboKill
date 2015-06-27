package game;

import game.objects.Robot;
import game.objects.enemies.Enemy;
import game.objects.enemies.Vahshi;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameField {

	private boolean isCleaned = false;
	private boolean isActivate = false;

	private String image;
	private Image fieldImage;

	private Image suroundImage;
	private String suround;

	private GameFieldModel model;
	private Enemy[] enemies;
	private int numOfEnemies;
	private Robot robot;

	private Animation openDoorUp;
	private Animation closeDoorUp;

	private Animation openDoorDown;
	private Animation closeDoorDown;

	private Animation openDoorRight;
	private Animation closeDoorRight;

	private Animation openDoorLeft;
	private Animation closeDoorLeft;
	// States of doors that is opened or is closed or should not be drawn( to
	// turn 1 , 0 , -1 )
	private int[] stateOfDoors;

	public GameField() {

		image = ("pics/fields/image 187.png");

	}

	public GameField(GameFieldModel model, int numOfEnemies, int[] stateOfDoors) {
		// Preparing environment
		image = ("pics/fields/image 593.jpg");
		suround = ("pics/fields/image 743.png");
		this.model = model;
		this.robot = Robot.getRobot();
		this.stateOfDoors = new int[4];
		this.stateOfDoors = stateOfDoors;
		this.numOfEnemies = numOfEnemies;

		// Create enemies for this field
		Random r = new Random();
		enemies = new Enemy[numOfEnemies];
		for (int i = 0; i < numOfEnemies; i++) {
			Position pos;
			do {
				pos = new Position(Math.abs(r.nextInt()) % 800, Math.abs(r
						.nextInt()) % 600);
				// For error detecting
				pos.setX(pos.getX() - 25);
				pos.setY(pos.getY() - 20);
			} while (!isValidPos(pos) || isNounCell(pos));
			pos.setX(pos.getX() + 25);
			pos.setY(pos.getY() + 20);
			enemies[i] = new Vahshi(robot.getPos(), pos, this);
		}
	}

	/**
	 * Getter for background of the field
	 * 
	 * @return
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Loads image
	 */
	public void init() {
		try {
			fieldImage = new Image(this.getImage());

		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			suroundImage = new Image(suround);

		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.initAll();

		// Initialize all enemies
		for (int i = 0; i < numOfEnemies; i++)
			enemies[i].init();

		openDoorUp = new Animation(createFramesForOpeningUp(), 85);
		closeDoorUp = new Animation(createFramesForClosingUp(), 85);

		openDoorDown = new Animation(createFramesForOpeningDown(), 85);
		closeDoorDown = new Animation(createFramesForClosingDown(), 85);

		openDoorRight = new Animation(createFramesForOpeningRight(), 85);
		closeDoorRight = new Animation(createFramesForClosingRight(), 85);

		openDoorLeft = new Animation(createFramesForOpeningLeft(), 85);
		closeDoorLeft = new Animation(createFramesForClosingLeft(), 85);

	}

	/**
	 * Draw the field
	 */
	public void draw(Graphics g) {

		fieldImage.draw(0, 0);

		model.drawAll(g);

		suroundImage.draw(0, 0);

		// Draw doors
		switch (stateOfDoors[0]) {
		case 0:
			closeDoorUp.setLooping(false);
			closeDoorUp.draw(350, 0);
			break;
		case 1:
			openDoorUp.setLooping(false);
			openDoorUp.draw(350, 0);
			break;
		case -1:
			break;
		}

		switch (stateOfDoors[1]) {
		case 0:
			closeDoorRight.setLooping(false);
			closeDoorRight.draw(740, 250);
			break;
		case 1:
			openDoorRight.setLooping(false);
			openDoorRight.draw(740, 250);
			break;
		case -1:
			break;
		}

		switch (stateOfDoors[2]) {
		case 0:
			closeDoorDown.setLooping(false);
			closeDoorDown.draw(350, 540);
			break;
		case 1:
			openDoorDown.setLooping(false);
			openDoorDown.draw(350, 540);
			break;
		case -1:
			break;
		}

		switch (stateOfDoors[3]) {
		case 0:
			closeDoorLeft.setLooping(false);
			closeDoorLeft.draw(0, 250);
			break;
		case 1:
			openDoorLeft.setLooping(false);
			openDoorLeft.draw(0, 250);
			break;
		case -1:
			break;
		}

		if (this.getModel().getHasExitText() == true)
			this.getModel().getExitText().draw(347, 65);
		// Draw all enemies
		for (int i = 0; i < numOfEnemies; i++) {
			if (enemies[i] != null)
				enemies[i].draw(g);
		}
	}

	/**
	 * Updates enemies in game container gc
	 * 
	 * @param gc
	 */
	public void update(GameContainer gc) {
		// Update all enemies
		
		
		for (int i = 0; i < numOfEnemies; i++) {
			if (enemies[i] != null) {
				enemies[i].update(gc);
				enemies[i].setRobotPos(robot.getPos());
				if (enemies[i].getHealth() == 0) {
					enemies[i] = null;
				}
			}
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 11; j++) {
				model.getCell(i, j).update();;
			}
		}

	}

	/**
	 * Getter for model of the field
	 * 
	 * @return
	 */
	public GameFieldModel getModel() {
		return model;
	}

	/**
	 * Check that this position is not blocked by a certain cell
	 * 
	 * @param pos
	 * @return false if is not blocked and true in otherwise
	 */
	public boolean isValidPos(Position pos) {
		if (model.getCellWithPos(pos.getX(), pos.getY()).getIsBlocked())
			return false;
		return true;
	}

	public boolean isNounCell(float xPos, float yPos) {
		if (model.getCellWithPos(xPos, yPos).getIsNoun())
			return true;
		return false;
	}

	public boolean isNounCell(Position pos) {
		if (model.getCellWithPos(pos.getX(), pos.getY()).getIsNoun())
			return true;
		return false;
	}

	/**
	 * Setter for isActivat
	 * 
	 * @param x
	 */
	public void setActivation(boolean x) {
		isActivate = x;
	}

	/**
	 * Getter for isActivate
	 * 
	 * @return
	 */
	public boolean getActivation() {
		return isActivate;
	}

	// Creates frames for opening
	private Image[] createFramesForOpeningUp() {
		Image[] frames = new Image[10];

		try {
			Image image1 = new Image("pics/door/image 1.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 2.png");
			frames[1] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 3.png");
			frames[2] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 4.png");
			frames[3] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 5.png");
			frames[4] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 6.png");
			frames[5] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 7.png");
			frames[6] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 8.png");
			frames[7] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 9.png");
			frames[8] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 10.png");
			frames[9] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;
	}

	private Image[] createFramesForClosingUp() {
		Image[] frames = new Image[10];

		try {
			Image image1 = new Image("pics/door/image 1.png");
			frames[9] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 2.png");
			frames[8] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 3.png");
			frames[7] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 4.png");
			frames[6] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 5.png");
			frames[5] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 6.png");
			frames[4] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 7.png");
			frames[3] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 8.png");
			frames[2] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 9.png");
			frames[1] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 10.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;
	}

	private Image[] createFramesForOpeningDown() {
		Image[] frames = new Image[10];

		try {
			Image image1 = new Image("pics/door/image 12.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 22.png");
			frames[1] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 32.png");
			frames[2] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 42.png");
			frames[3] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 52.png");
			frames[4] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 62.png");
			frames[5] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 72.png");
			frames[6] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 82.png");
			frames[7] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 92.png");
			frames[8] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 102.png");
			frames[9] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;
	}

	private Image[] createFramesForClosingDown() {
		Image[] frames = new Image[10];

		try {
			Image image1 = new Image("pics/door/image 12.png");
			frames[9] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 22.png");
			frames[8] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 32.png");
			frames[7] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 42.png");
			frames[6] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 52.png");
			frames[5] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 62.png");
			frames[4] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 72.png");
			frames[3] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 82.png");
			frames[2] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 92.png");
			frames[1] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 102.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;
	}

	private Image[] createFramesForOpeningRight() {
		Image[] frames = new Image[10];

		try {
			Image image1 = new Image("pics/door/image 11.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 21.png");
			frames[1] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 31.png");
			frames[2] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 41.png");
			frames[3] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 51.png");
			frames[4] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 61.png");
			frames[5] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 71.png");
			frames[6] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 81.png");
			frames[7] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 91.png");
			frames[8] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 101.png");
			frames[9] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;
	}

	private Image[] createFramesForClosingRight() {
		Image[] frames = new Image[10];

		try {
			Image image1 = new Image("pics/door/image 11.png");
			frames[9] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 21.png");
			frames[8] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 31.png");
			frames[7] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 41.png");
			frames[6] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 51.png");
			frames[5] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 61.png");
			frames[4] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 71.png");
			frames[3] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 81.png");
			frames[2] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 91.png");
			frames[1] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 101.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;
	}

	private Image[] createFramesForOpeningLeft() {
		Image[] frames = new Image[10];

		try {
			Image image1 = new Image("pics/door/image 13.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 23.png");
			frames[1] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 33.png");
			frames[2] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 43.png");
			frames[3] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 53.png");
			frames[4] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 63.png");
			frames[5] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 73.png");
			frames[6] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 83.png");
			frames[7] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 93.png");
			frames[8] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 103.png");
			frames[9] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;
	}

	private Image[] createFramesForClosingLeft() {
		Image[] frames = new Image[10];

		try {
			Image image1 = new Image("pics/door/image 13.png");
			frames[9] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 23.png");
			frames[8] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 33.png");
			frames[7] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 43.png");
			frames[6] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 53.png");
			frames[5] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 63.png");
			frames[4] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 73.png");
			frames[3] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 83.png");
			frames[2] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 93.png");
			frames[1] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image1 = new Image("pics/door/image 103.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;
	}
}
