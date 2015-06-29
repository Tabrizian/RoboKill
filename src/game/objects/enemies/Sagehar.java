package game.objects.enemies;

import game.EnemiesDatabase;
import game.GameField;
import game.Position;
import game.objects.Robot;
import game.objects.prizes.Money;
import game.objects.prizes.Plunder;
import game.objects.prizes.Shield;
import game.objects.prizes.guns.HeavyGun;
import game.objects.prizes.guns.LightGun;
import game.objects.prizes.guns.MediumGun;
import game.objects.weapons.MissilesDatabase;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Sagehar extends Enemy {

	private boolean isMoving = true;
	private Animation moving;
	private Animation fixed;
	private Image[] images;
	private Image[] fixes;
	private int duration;
	private float imageAngleRad = 0;
	private float imageAngleDeg;
	private float x = 50;
	private float y = 50;
	private Position pos;
	private Position robotPosition;
	private GameField field;

	public Sagehar(Position pos, GameField field) {
		health = 100;
		this.field = field;
		this.pos = new Position(pos);
		destroyedDamage = 50;
	}

	public Sagehar(Position pos, GameField field, Plunder plunder) {
		health = 100;
		this.field = field;
		this.pos = new Position(pos);
		if (plunder instanceof Money)
			this.plunder = new Money();
		else if (plunder instanceof Shield)
			this.plunder = new Shield();
		else if( plunder instanceof LightGun )
			this.plunder = new LightGun() ;
		else if( plunder instanceof HeavyGun )
			this.plunder = new HeavyGun() ;
		else if( plunder instanceof MediumGun )
			this.plunder = new MediumGun() ;
		destroyedDamage = 50;
	}

	public void init() {
		images = new Image[13];
		fixes = new Image[1];
		try {
			images[0] = new Image("pics/enemy/Ghozmit/image 138.png");
			images[1] = new Image("pics/enemy/Ghozmit/image 149.png");
			images[2] = new Image("pics/enemy/Ghozmit/image 245.png");
			images[3] = new Image("pics/enemy/Ghozmit/image 339.png");
			images[4] = new Image("pics/enemy/Ghozmit/image 355.png");
			images[5] = new Image("pics/enemy/Ghozmit/image 469.png");
			images[6] = new Image("pics/enemy/Ghozmit/image 510.png");
			images[7] = new Image("pics/enemy/Ghozmit/image 556.png");
			images[8] = new Image("pics/enemy/Ghozmit/image 874.png");
			images[9] = new Image("pics/enemy/Ghozmit/image 907.png");
			images[10] = new Image("pics/enemy/Ghozmit/image 935.png");
			images[11] = new Image("pics/enemy/Ghozmit/image 943.png");
			images[12] = new Image("pics/enemy/Ghozmit/image 982.png");
			fixes[0] = images[0];
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moving = new Animation(images, 120);
		fixed = new Animation(fixes, 100);
		robotPosition = Robot.getRobot().getPos();
	}
	@Override
	public void draw(Graphics g) {
		if (health > 0) {
			if (isMoving) {

				moving.draw(pos.getX() - images[0].getWidth() / 2, pos.getY()
						- images[0].getHeight() / 2);
			} else
				fixed.draw(pos.getX() - images[0].getWidth() / 2, pos.getY()
						- images[0].getHeight() / 2);
		}

	}

	public void update(GameContainer gc) {
		float xPos = this.getPos().getX();
		float yPos = this.getPos().getY();

		if (pos.getY() - 10 > Robot.getRobot().getPos().getY() + 10) {
			yPos -= 0.05;
			isMoving = true;
		}

		if (pos.getY() + 10 < Robot.getRobot().getPos().getY() - 10) {
			yPos += 0.05;
			isMoving = true;
		}
		if (pos.getX() + 10 < Robot.getRobot().getPos().getX() - 10) {
			xPos += 0.05;
			isMoving = true;
		}
		if (pos.getX() - 10 > Robot.getRobot().getPos().getX() + 10) {
			xPos -= 0.05;
			isMoving = true;
		}/*
		 * else { isMoving = false; }
		 */

		if (field.isValidPos(new Position(xPos, yPos))
				&& !field.isNounCell(xPos, yPos)) {
			this.setPos(new Position(xPos, yPos));
		}

		double dx = Robot.getRobot().getPos().getX() - this.getPos().getX();
		double dy = Robot.getRobot().getPos().getY() - this.getPos().getY();
		imageAngleRad = (float) (Math.atan2(dy, dx) - Math.PI / 2);

		imageAngleDeg = (float) (imageAngleRad * 180 / Math.PI);

		for (int i = 0; i < images.length; i++) {
			images[i].setRotation(imageAngleDeg);
		}

		int healthReduction = MissilesDatabase.getMissilesDatabase()
				.explodeAreaForEnemy(new Position(pos.getX() - 24, pos.getY() - 24), 48,
						48);

		if (healthReduction > health)
			health = 0;
		else
			health -= healthReduction;
		if(health == 0){
			EnemiesDatabase.getEnemiesDatabase().remove(this);
		}

	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

}
