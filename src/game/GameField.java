package game;

import game.objects.Robot;
import game.objects.enemies.Enemy;
import game.objects.enemies.Zombie;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameField {

	private boolean isCleaned = false;
	private boolean isActivate = true;

	private String image;
	private Image fieldImage;

	private Image suroundImage;
	private String suround;

	private GameFieldModel model;
	private Enemy[] enemies;
	private Robot robot;

	private Animation openDoor;
	private Animation closeDoor;
	// States of doors that is opened or is closed or should not be drawn( to
	// turn 1 , 0 , -1 )
	private int[] stateOfDoors;

	public GameField() {

		image = ("pics/fields/image 187.png");

	}

	public GameField(GameFieldModel model, int numOfEnemies, Robot robot,
			int[] stateOfDoors) {
		// Preparing environment
		image = ("pics/fields/image 593.jpg");
		suround = ("pics/fields/image 743.png");
		this.model = model;
		this.robot = robot;
		this.stateOfDoors = new int[4];
		this.stateOfDoors = stateOfDoors;

		// Create enemies for this field
		enemies = new Enemy[numOfEnemies];
		enemies[0] = new Zombie(robot.getPos(), new Position(300, 300), this);
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
		((Zombie) enemies[0]).init();

		openDoor = new Animation(createFramesForOpening(), 85);
		closeDoor = new Animation(createFramesForClosing(), 85);

	}

	/**
	 * Draw the field
	 */
	public void draw(Graphics g) {

		fieldImage.draw(0, 0);

		model.drawAll();

		suroundImage.draw(0, 0);

		//Draw doors
		switch (stateOfDoors[0]) {
		case 0:
			closeDoor.setLooping(false);
			closeDoor.draw(350, 0);
			break;
		case 1:
			openDoor.setLooping(false);
			openDoor.draw(350, 0);
			break;
		case -1:
			break;
		}
		
		switch (stateOfDoors[1]) {
		case 0:
			closeDoor.setLooping(false);
			closeDoor.draw(350, 0);
			break;
		case 1:
			openDoor.setLooping(false);
			openDoor.draw(350, 0);
			break;
		case -1:
			break;
		}
		
		switch (stateOfDoors[2]) {
		case 0:
			closeDoor.setLooping(false);
			closeDoor.draw(350, 0);
			break;
		case 1:
			openDoor.setLooping(false);
			openDoor.draw(350, 0);
			break;
		case -1:
			break;
		}
		
		switch (stateOfDoors[3]) {
		case 0:
			closeDoor.setLooping(false);
			closeDoor.draw(350, 0);
			break;
		case 1:
			openDoor.setLooping(false);
			openDoor.draw(350, 0);
			break;
		case -1:
			break;
		}

		if (this.getModel().getHasExitText() == true)
			this.getModel().getExitText().draw(347, 65);
		// Draw all enemies
		((Zombie) enemies[0]).draw();

	}

	/**
	 * Updates enemies in game container gc
	 * 
	 * @param gc
	 */
	public void update(GameContainer gc) {
		// Update all enemies
		((Zombie) enemies[0]).update(gc);
		((Zombie) enemies[0]).setRobotPos(robot.getPos());
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

	// Creates frames for opening
	private Image[] createFramesForOpening() {
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

	private Image[] createFramesForClosing() {
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
}
