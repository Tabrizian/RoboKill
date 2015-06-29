package game.objects.enemies;

import game.EnemiesDatabase;
import game.GameField;
import game.Position;
import game.objects.prizes.Money;
import game.objects.prizes.Plunder;
import game.objects.prizes.Shield;
import game.objects.weapons.MissilesDatabase;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Vahshi extends Enemy {

	private float imageAngleRad = 0;
	private float imageAngleDeg = 0;
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

	private Image imageOfBody;

	private Animation toUpRight;

	private Animation toDownLeft;

	private Animation toUpLeft;

	private Animation toDownRight;

	private GameField field;

	public Vahshi(Position robotPos, Position pos, GameField field) {
		super();

		this.pos = new Position(pos);
		health = 100;

		robotPosition = pos;
		destroyedDamage = 20;
		this.field = field;
	}

	public Vahshi(Position robotPos, Position pos, GameField field,
			Plunder plunder) {
		super();

		this.pos = new Position(pos);
		health = 100;
		destroyedDamage = 20;
		robotPosition = pos;

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

	public void setPos(Position pos) {
		this.pos = pos;
	}

	/**
	 * Loads image of robot
	 */
	public void init() {
		imageOfBody = createFixStateFrame()[0];
		toUp = new Animation(createToUpFrames(), 150);
		fixState = new Animation(createFixStateFrame(), 150);
		toDown = new Animation(createToDownFrames(), 150);
		toRight = new Animation(createToRightFrames(), 150);
		toLeft = new Animation(createToLeftFrames(), 150);
		toDownLeft = new Animation(createToDownLeftFrames(), 120);
		toUpRight = new Animation(createToUpRightFrames(), 120);
		toDownRight = new Animation(createToDownRightFrames(), 120);
		toUpLeft = new Animation(createToUpLeftFrames(), 120);
	}

	/**
	 * Draw robot with an angle for rotating that based on mouse position
	 * 
	 * @param angle
	 */
	@Override
	public void draw(Graphics g) {
		g.drawRect(pos.getX(), pos.getY(), 48, 48);
		if (health > 0) {
			// Manage drawing animations
			if (iskeyUpPressed == true && isKeyRightPressed == true) {
				fixState.stop();
				toUp.stop();
				toDown.stop();
				toRight.stop();
				toLeft.stop();
				toDownLeft.stop();
				toDownRight.stop();
				toUpLeft.stop();
				toUpRight.draw(pos.getX() - imageOfBody.getWidth() / 2,
						pos.getY() - imageOfBody.getHeight() / 2);
				toUpRight.start();
			} else if (iskeyDownPressed == true && isKeyLeftPressed == true) {
				fixState.stop();
				toUp.stop();
				toDown.stop();
				toRight.stop();
				toLeft.stop();
				toUpRight.stop();
				toDownRight.stop();
				toUpLeft.stop();
				toDownLeft.draw(pos.getX() - imageOfBody.getWidth() / 2,
						pos.getY() - imageOfBody.getHeight() / 2);
				toDownLeft.start();
			} else if (iskeyUpPressed == true && isKeyLeftPressed == true) {
				fixState.stop();
				toUp.stop();
				toDown.stop();
				toRight.stop();
				toLeft.stop();
				toUpRight.stop();
				toDownRight.stop();
				toDownLeft.stop();
				toUpLeft.draw(pos.getX() - imageOfBody.getWidth() / 2,
						pos.getY() - imageOfBody.getHeight() / 2);
				toUpLeft.start();

			} else if (iskeyDownPressed == true && isKeyRightPressed == true) {
				fixState.stop();
				toUp.stop();
				toDown.stop();
				toRight.stop();
				toLeft.stop();
				toUpRight.stop();
				toUpLeft.stop();
				toDownLeft.stop();
				toDownRight.draw(pos.getX() - imageOfBody.getWidth() / 2,
						pos.getY() - imageOfBody.getHeight() / 2);
				toDownRight.start();
			} else if (iskeyUpPressed == true) {
				fixState.stop();
				toDown.stop();
				toRight.stop();
				toLeft.stop();
				toUpRight.stop();
				toDownLeft.stop();
				toDownRight.stop();
				toUpLeft.stop();
				toUp.draw(pos.getX() - imageOfBody.getWidth() / 2, pos.getY()
						- imageOfBody.getHeight() / 2);
				toUp.start();
			}

			else if (iskeyDownPressed == true) {
				toUpRight.stop();
				fixState.stop();
				toUp.stop();
				toRight.stop();
				toLeft.stop();
				toDownLeft.stop();
				toDownRight.stop();
				toUpLeft.stop();
				toDown.draw(pos.getX() - imageOfBody.getWidth() / 2, pos.getY()
						- imageOfBody.getHeight() / 2);
				toDown.start();

			}

			else if (isKeyRightPressed == true) {
				fixState.stop();
				toUpRight.stop();
				toUp.stop();
				toDown.stop();
				toLeft.stop();
				toDownLeft.stop();
				toDownRight.stop();
				toUpLeft.stop();
				toRight.draw(pos.getX() - imageOfBody.getWidth() / 2,
						pos.getY() - imageOfBody.getHeight() / 2);
				toRight.start();
			} else if (isKeyLeftPressed == true) {
				fixState.stop();
				toUp.stop();
				toDown.stop();
				toRight.stop();
				toUpRight.stop();
				toDownLeft.stop();
				toDownRight.stop();
				toUpLeft.stop();
				toLeft.draw(pos.getX() - imageOfBody.getWidth() / 2, pos.getY()
						- imageOfBody.getHeight() / 2);
				toLeft.start();
			} else {
				toUp.stop();
				toDown.stop();
				toRight.stop();
				toLeft.stop();
				toUpRight.stop();
				toDownLeft.stop();
				toDownRight.stop();
				toUpLeft.stop();
				fixState.draw(pos.getX() - imageOfBody.getWidth() / 2,
						pos.getY() - imageOfBody.getHeight() / 2);
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
			yPos -= 0.1;
			iskeyUpPressed = true;
		} else
			iskeyUpPressed = false;
		if (pos.getY() + 10 < robotPosition.getY() - 10) {
			yPos += 0.1;
			iskeyDownPressed = true;
		} else
			iskeyDownPressed = false;
		if (pos.getX() + 10 < robotPosition.getX() - 10) {
			xPos += 0.1;
			isKeyRightPressed = true;
		} else
			isKeyRightPressed = false;
		if (pos.getX() - 10 > robotPosition.getX() + 10) {
			xPos -= 0.1;
			isKeyLeftPressed = true;
		} else
			isKeyLeftPressed = false;

		if (field.isValidPos(new Position(xPos, yPos))
				&& !field.isNounCell(xPos, yPos)) {
			this.setPos(new Position(xPos, yPos));
		}

		int healthReduction = MissilesDatabase.getMissilesDatabase()
				.explodeAreaForEnemy(new Position(pos.getX(), pos.getY()), 30,
						30);

		if (healthReduction > health)
			health = 0;
		else
			health -= healthReduction;
		if (health == 0) {
			EnemiesDatabase.getEnemiesDatabase().remove(this);
		}

	}

	// Create frames of an animation
	private Image[] createToUpFrames() {

		Image[] frames = new Image[6];

		try {
			Image image1 = new Image("pics/enemy/Vahshi/image 1.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image2 = new Image("pics/enemy/Vahshi/image 2.png");
			frames[1] = image2;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image3 = new Image("pics/enemy/Vahshi/image 3.png");
			frames[2] = image3;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image4 = new Image("pics/enemy/Vahshi/image 4.png");
			frames[3] = image4;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image5 = new Image("pics/enemy/Vahshi/image 5.png");
			frames[4] = image5;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image6 = new Image("pics/enemy/Vahshi/image 6.png");
			frames[5] = image6;
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
			Image image1 = new Image("pics/enemy/Vahshi/image 2.png");
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
			Image image1 = new Image("pics/enemy/Vahshi/image 12.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image2 = new Image("pics/enemy/Vahshi/image 22.png");
			frames[1] = image2;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image3 = new Image("pics/enemy/Vahshi/image 32.png");
			frames[2] = image3;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image4 = new Image("pics/enemy/Vahshi/image 42.png");
			frames[3] = image4;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image5 = new Image("pics/enemy/Vahshi/image 52.png");
			frames[4] = image5;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image6 = new Image("pics/enemy/Vahshi/image 62.png");
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
			Image image1 = new Image("pics/enemy/Vahshi/image 11.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image2 = new Image("pics/enemy/Vahshi/image 21.png");
			frames[1] = image2;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image3 = new Image("pics/enemy/Vahshi/image 31.png");
			frames[2] = image3;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image4 = new Image("pics/enemy/Vahshi/image 41.png");
			frames[3] = image4;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image5 = new Image("pics/enemy/Vahshi/image 51.png");
			frames[4] = image5;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image6 = new Image("pics/enemy/Vahshi/image 61.png");
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
			Image image1 = new Image("pics/enemy/Vahshi/image 13.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image2 = new Image("pics/enemy/Vahshi/image 23.png");
			frames[1] = image2;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image3 = new Image("pics/enemy/Vahshi/image 33.png");
			frames[2] = image3;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image4 = new Image("pics/enemy/Vahshi/image 43.png");
			frames[3] = image4;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image5 = new Image("pics/enemy/Vahshi/image 53.png");
			frames[4] = image5;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image6 = new Image("pics/enemy/Vahshi/image 63.png");
			frames[5] = image6;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;

	}

	private Image[] createToUpRightFrames() {

		Image[] frames = new Image[6];

		try {
			Image image1 = new Image("pics/enemy/Vahshi/image 14.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image2 = new Image("pics/enemy/Vahshi/image 24.png");
			frames[1] = image2;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image3 = new Image("pics/enemy/Vahshi/image 34.png");
			frames[2] = image3;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image4 = new Image("pics/enemy/Vahshi/image 44.png");
			frames[3] = image4;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image5 = new Image("pics/enemy/Vahshi/image 54.png");
			frames[4] = image5;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image6 = new Image("pics/enemy/Vahshi/image 64.png");
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
			Image image1 = new Image("pics/enemy/Vahshi/image 16.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image2 = new Image("pics/enemy/Vahshi/image 26.png");
			frames[1] = image2;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image3 = new Image("pics/enemy/Vahshi/image 36.png");
			frames[2] = image3;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image4 = new Image("pics/enemy/Vahshi/image 46.png");
			frames[3] = image4;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image5 = new Image("pics/enemy/Vahshi/image 56.png");
			frames[4] = image5;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image6 = new Image("pics/enemy/Vahshi/image 66.png");
			frames[5] = image6;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;

	}

	private Image[] createToDownRightFrames() {

		Image[] frames = new Image[6];

		try {
			Image image1 = new Image("pics/enemy/Vahshi/image 15.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image2 = new Image("pics/enemy/Vahshi/image 25.png");
			frames[1] = image2;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image3 = new Image("pics/enemy/Vahshi/image 35.png");
			frames[2] = image3;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image4 = new Image("pics/enemy/Vahshi/image 45.png");
			frames[3] = image4;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image5 = new Image("pics/enemy/Vahshi/image 55.png");
			frames[4] = image5;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image6 = new Image("pics/enemy/Vahshi/image 65.png");
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
			Image image1 = new Image("pics/enemy/Vahshi/image 17.png");
			frames[0] = image1;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image2 = new Image("pics/enemy/Vahshi/image 27.png");
			frames[1] = image2;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image3 = new Image("pics/enemy/Vahshi/image 37.png");
			frames[2] = image3;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image4 = new Image("pics/enemy/Vahshi/image 47.png");
			frames[3] = image4;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image5 = new Image("pics/enemy/Vahshi/image 57.png");
			frames[4] = image5;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Image image6 = new Image("pics/enemy/Vahshi/image 67.png");
			frames[5] = image6;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return frames;

	}

}
