package game.objects.enemies;

import game.EnemiesDatabase;
import game.GameField;
import game.Position;
import game.objects.prizes.Money;
import game.objects.prizes.Plunder;
import game.objects.prizes.Shield;
import game.objects.weapons.MissilesDatabase;
import game.objects.weapons.Weapon;
import game.objects.weapons.blasters.LightBlaster;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Zombie extends Enemy {

	private float imageAngleRad = 0;
	private float imageAngleDeg = 0;

	private String imageOfBodyAddress;

	private Image imageOfBody;

	/**
	 * Weapons that robot carries them
	 */
	private Weapon[] weapons;
	/**
	 * Animate robot for moving to up
	 */
	private Animation toUp;
	private boolean iskeyUpPressed = false;

	private Animation fixState;

	private Animation toDown;
	private boolean iskeyDownPressed = false;

	private Animation toRight;
	private boolean isKeyRightPressed = false;

	private Animation toLeft;
	private boolean isKeyLeftPressed = false;

	private Animation toUpRight;

	private Animation toDownLeft;

	private Animation toUpLeft;

	private Animation toDownRight;

	private GameField field;

	public Zombie(Position robotPos, Position pos, GameField field) {
		super();

		this.pos = new Position(pos);
		health = 100;

		imageOfBodyAddress = ("pics/enemy/Zombie/image 98.png");

		robotPosition = pos;

		weapons = new Weapon[4];

		this.field = field;
		destroyedDamage = 40;
	}

	public Zombie(Position robotPos, Position pos, GameField field,
			Plunder plunder) {
		super();

		this.pos = new Position(pos);
		health = 100;

		imageOfBodyAddress = ("pics/enemy/Zombie/image 98.png");

		robotPosition = pos;

		weapons = new Weapon[4];

		destroyedDamage = 40;
		this.field = field;
		if (plunder instanceof Money)
			this.plunder = new Money();
		else if (plunder instanceof Shield)
			this.plunder = new Shield();
	}

	public void setRobotPos(Position pos) {
		this.robotPosition = pos;
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

	public void setPos(Position pos) {
		this.pos = pos;
	}

	/**
	 * Loads image of robot
	 */
	public void init() {
		try {
			imageOfBody = new Image(this.getImageOfBody());
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		toUp = new Animation(createToUpFrames(), 150);
		fixState = new Animation(createFixStateFrame(), 150);
		toDown = new Animation(createToDownFrames(), 150);
		toRight = new Animation(createToRightFrames(), 150);
		toLeft = new Animation(createToLeftFrames(), 150);
		toDownLeft = new Animation(createToDownLeftFrames(), 120);
		toUpRight = new Animation(createToUpRightFrames(), 120);
		toDownRight = new Animation(createToDownRightFrames(), 120);
		toUpLeft = new Animation(createToUpLeftFrames(), 120);

		weapons[0] = new LightBlaster(0, "enemy");
		weapons[1] = null;
		weapons[2] = null;
		weapons[3] = new LightBlaster(3, "enemy");
	}

	/**
	 * Draw robot with an angle for rotating that based on mouse position
	 * 
	 * @param angle
	 */
	@Override
	public void draw(Graphics g) {
		g.drawRect(pos.getX() - 24, pos.getY() - 24, 48, 48);
		if (health > 0) {
			imageOfBody.setRotation(imageAngleDeg);
			imageOfBody.drawCentered(pos.getX(), pos.getY());

			for (Weapon gun : weapons) {
				if (gun != null)
					gun.draw();

			}

			// Manage drawing animations
			if (iskeyUpPressed == true && isKeyRightPressed == true) {
				toUpRight.draw(pos.getX() - imageOfBody.getWidth() / 2,
						pos.getY() - imageOfBody.getHeight() / 2);
				toUpRight.start();
				imageOfBody.setRotation(imageAngleDeg);
				imageOfBody.drawCentered(pos.getX(), pos.getY());
			} else if (iskeyDownPressed == true && isKeyLeftPressed == true) {
				toDownLeft.draw(pos.getX() - imageOfBody.getWidth() / 2,
						pos.getY() - imageOfBody.getHeight() / 2);
				toDownLeft.start();
				imageOfBody.setRotation(imageAngleDeg);
				imageOfBody.drawCentered(pos.getX(), pos.getY());
			} else if (iskeyUpPressed == true && isKeyLeftPressed == true) {
				toUpLeft.draw(pos.getX() - imageOfBody.getWidth() / 2,
						pos.getY() - imageOfBody.getHeight() / 2);
				toUpLeft.start();
				imageOfBody.setRotation(imageAngleDeg);
				imageOfBody.drawCentered(pos.getX(), pos.getY());
			} else if (iskeyDownPressed == true && isKeyRightPressed == true) {
				toDownRight.draw(pos.getX() - imageOfBody.getWidth() / 2,
						pos.getY() - imageOfBody.getHeight() / 2);
				toDownRight.start();
				imageOfBody.setRotation(imageAngleDeg);
				imageOfBody.drawCentered(pos.getX(), pos.getY());
			} else if (iskeyUpPressed == true) {
				toUp.draw(pos.getX() - imageOfBody.getWidth() / 2, pos.getY()
						- imageOfBody.getHeight() / 2);
				toUp.start();
				imageOfBody.setRotation(imageAngleDeg);
				imageOfBody.drawCentered(pos.getX(), pos.getY());
			}

			else if (iskeyDownPressed == true) {
				toDown.draw(pos.getX() - imageOfBody.getWidth() / 2, pos.getY()
						- imageOfBody.getHeight() / 2);
				toDown.start();
				imageOfBody.setRotation(imageAngleDeg);
				imageOfBody.drawCentered(pos.getX(), pos.getY());
			}

			else if (isKeyRightPressed == true) {
				toRight.draw(pos.getX() - imageOfBody.getWidth() / 2,
						pos.getY() - imageOfBody.getHeight() / 2);
				toRight.start();
				imageOfBody.setRotation(imageAngleDeg);
				imageOfBody.drawCentered(pos.getX(), pos.getY());
			} else if (isKeyLeftPressed == true) {
				toLeft.draw(pos.getX() - imageOfBody.getWidth() / 2, pos.getY()
						- imageOfBody.getHeight() / 2);
				toLeft.start();
				imageOfBody.setRotation(imageAngleDeg);
				imageOfBody.drawCentered(pos.getX(), pos.getY());
			} else {
				fixState.draw(pos.getX() - imageOfBody.getWidth() / 2,
						pos.getY() - imageOfBody.getHeight() / 2);
				imageOfBody.setRotation(imageAngleDeg);
				imageOfBody.drawCentered(pos.getX(), pos.getY());
			}
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

		if (pos.getY() - 10 > robotPosition.getY() + 10) {
			yPos -= 0.05;
			iskeyUpPressed = true;
		} else
			iskeyUpPressed = false;
		if (pos.getY() + 10 < robotPosition.getY() - 10) {
			yPos += 0.05;
			iskeyDownPressed = true;
		} else
			iskeyDownPressed = false;
		if (pos.getX() + 10 < robotPosition.getX() - 10) {
			xPos += 0.05;
			isKeyRightPressed = true;
		} else
			isKeyRightPressed = false;
		if (pos.getX() - 10 > robotPosition.getX() + 10) {
			xPos -= 0.05;
			isKeyLeftPressed = true;
		} else
			isKeyLeftPressed = false;

		if (field.isValidPos(new Position(xPos, yPos))
				&& !field.isNounCell(xPos, yPos)) {
			this.setPos(new Position(xPos, yPos));
		}

		double dx = robotPosition.getX() - this.getPos().getX();
		double dy = robotPosition.getY() - this.getPos().getY();
		imageAngleRad = (float) (Math.atan2(dy, dx) - Math.PI / 2);

		imageAngleDeg = (float) (imageAngleRad * 180 / Math.PI);

		Random r = new Random();
		int x = r.nextInt() % 5;
		if (x == 2)
			fire();

		for (Weapon gun : weapons) {
			if (gun != null)
				gun.update(gc);
		}

		int healthReduction = MissilesDatabase.getMissilesDatabase()
				.explodeAreaForEnemy(new Position(pos.getX(), pos.getY()), 45,
						45);

		if (healthReduction > health)
			health = 0;
		else {
			health -= healthReduction;
		}

		if (health == 0) {
			EnemiesDatabase.getEnemiesDatabase().remove(this);
		}

	}

	/**
	 * Fires missiles
	 */
	public void fire() {

		for (Weapon gun : weapons) {
			if (gun != null)
				gun.shot(imageAngleRad, pos, imageOfBody.getWidth() * 70 / 100);
		}
	}

	// Create frames of an animation
	private Image[] createToUpFrames() {

		Image[] frames = new Image[6];

		try {
			Image image1 = new Image("pics/enemy/Zombie/image 283.png");
			frames[5] = image1;
			Image image2 = new Image("pics/enemy/Zombie/image 237.png");
			frames[4] = image2;
			Image image3 = new Image("pics/enemy/Zombie/image 610.png");
			frames[3] = image3;
			Image image4 = new Image("pics/enemy/Zombie/image 237.png");
			frames[2] = image4;
			Image image5 = new Image("pics/enemy/Zombie/image 283.png");
			frames[1] = image5;
			Image image6 = new Image("pics/enemy/Zombie/image 582.png");
			frames[0] = image6;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;

	}

	// Create frames of an animation
	private Image[] createFixStateFrame() {
		Image[] frames = new Image[1];

		try {
			Image image1 = new Image("pics/enemy/Zombie/image 283.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;
	}

	// Create frames of an animation
	private Image[] createToDownFrames() {

		Image[] frames = new Image[6];

		try {
			Image image1 = new Image("pics/enemy/Zombie/image 283.png");
			frames[0] = image1;
			Image image2 = new Image("pics/enemy/Zombie/image 237.png");
			frames[1] = image2;
			Image image3 = new Image("pics/enemy/Zombie/image 610.png");
			frames[2] = image3;
			Image image4 = new Image("pics/enemy/Zombie/image 237.png");
			frames[3] = image4;
			Image image5 = new Image("pics/enemy/Zombie/image 283.png");
			frames[4] = image5;
			Image image6 = new Image("pics/enemy/Zombie/image 582.png");
			frames[5] = image6;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return frames;

	}

	// Create frames of an animation
	private Image[] createToRightFrames() {

		Image[] frames = new Image[6];

		try {
			Image image1 = new Image("pics/enemy/Zombie/image 2831.png");
			frames[0] = image1;
			Image image2 = new Image("pics/enemy/Zombie/image 2371.png");
			frames[1] = image2;
			Image image3 = new Image("pics/enemy/Zombie/image 6101.png");
			frames[2] = image3;
			Image image4 = new Image("pics/enemy/Zombie/image 2371.png");
			frames[3] = image4;
			Image image5 = new Image("pics/enemy/Zombie/image 2831.png");
			frames[4] = image5;
			Image image6 = new Image("pics/enemy/Zombie/image 5821.png");
			frames[5] = image6;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return frames;

	}

	// Create frames of an animation
	private Image[] createToLeftFrames() {

		Image[] frames = new Image[6];

		try {
			Image image1 = new Image("pics/enemy/Zombie/image 2831.png");
			frames[5] = image1;
			Image image2 = new Image("pics/enemy/Zombie/image 2371.png");
			frames[4] = image2;
			Image image3 = new Image("pics/enemy/Zombie/image 6101.png");
			frames[3] = image3;
			Image image4 = new Image("pics/enemy/Zombie/image 2371.png");
			frames[2] = image4;
			Image image5 = new Image("pics/enemy/Zombie/image 2831.png");
			frames[1] = image5;
			Image image6 = new Image("pics/enemy/Zombie/image 5821.png");
			frames[0] = image6;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return frames;

	}

	private Image[] createToUpRightFrames() {

		Image[] frames = new Image[6];

		try {
			Image image1 = new Image("pics/enemy/Zombie/image 2832.png");
			frames[0] = image1;
			Image image2 = new Image("pics/enemy/Zombie/image 2372.png");
			frames[1] = image2;
			Image image3 = new Image("pics/enemy/Zombie/image 6102.png");
			frames[2] = image3;
			Image image4 = new Image("pics/enemy/Zombie/image 2372.png");
			frames[3] = image4;
			Image image5 = new Image("pics/enemy/Zombie/image 2832.png");
			frames[4] = image5;
			Image image6 = new Image("pics/enemy/Zombie/image 5822.png");
			frames[5] = image6;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return frames;

	}

	private Image[] createToDownLeftFrames() {

		Image[] frames = new Image[6];

		try {
			Image image1 = new Image("pics/enemy/Zombie/image 2832.png");
			frames[5] = image1;
			Image image2 = new Image("pics/enemy/Zombie/image 2372.png");
			frames[4] = image2;
			Image image3 = new Image("pics/enemy/Zombie/image 6102.png");
			frames[3] = image3;
			Image image4 = new Image("pics/enemy/Zombie/image 2372.png");
			frames[2] = image4;
			Image image5 = new Image("pics/enemy/Zombie/image 2832.png");
			frames[1] = image5;
			Image image6 = new Image("pics/enemy/Zombie/image 5822.png");
			frames[0] = image6;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return frames;

	}

	private Image[] createToDownRightFrames() {

		Image[] frames = new Image[6];
		try {
			Image image1 = new Image("pics/enemy/Zombie/image 2833.png");
			frames[0] = image1;
			Image image2 = new Image("pics/enemy/Zombie/image 2373.png");
			frames[1] = image2;
			Image image3 = new Image("pics/enemy/Zombie/image 6103.png");
			frames[2] = image3;
			Image image4 = new Image("pics/enemy/Zombie/image 2373.png");
			frames[3] = image4;
			Image image5 = new Image("pics/enemy/Zombie/image 2833.png");
			frames[4] = image5;
			Image image6 = new Image("pics/enemy/Zombie/image 5823.png");
			frames[5] = image6;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return frames;

	}

	private Image[] createToUpLeftFrames() {

		Image[] frames = new Image[6];

		try {
			Image image1 = new Image("pics/enemy/Zombie/image 2833.png");
			frames[5] = image1;
			Image image2 = new Image("pics/enemy/Zombie/image 2373.png");
			frames[4] = image2;
			Image image3 = new Image("pics/enemy/Zombie/image 6103.png");
			frames[3] = image3;
			Image image4 = new Image("pics/enemy/Zombie/image 2373.png");
			frames[2] = image4;
			Image image5 = new Image("pics/enemy/Zombie/image 2833.png");
			frames[1] = image5;
			Image image6 = new Image("pics/enemy/Zombie/image 5823.png");
			frames[0] = image6;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return frames;

	}
}
