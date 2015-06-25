package game;

import game.objects.Robot;
import game.objects.enemies.Enemy;
import game.objects.enemies.Zombie;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameField {

	private boolean isCleaned = false;
	private boolean isActivate = true;

	private String image;
	private Image fieldImage;
	
	private Image suroundImage ;
	private String suround ;
	
	private GameFieldModel model;
	private Enemy[] enemies ;
	private Robot robot ;
	
	public GameField() {

		image = ("pics/fields/image 187.png");

	}

	public GameField(GameFieldModel model , int numOfEnemies , Robot robot) {
		image = ("pics/fields/image 593.jpg");
		suround = ("pics/fields/image 743.png") ;
		this.model = model;
		this.robot = robot ;
		//Create enemies for this field
		enemies = new Enemy[numOfEnemies] ;
		enemies[0] = new Zombie(robot.getPos() , new Position(300, 300)) ;
	}

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
		
		//Initialize all enemies
		((Zombie) enemies[0]).init() ;

	}

	/**
	 * Draw image
	 */
	public void draw(Graphics g) {

		fieldImage.draw(0, 0);

		model.drawAll();
		
		suroundImage.draw(0, 0);
		
		//Draw all enemies
		((Zombie) enemies[0]).draw() ;

	}

	public void update(GameContainer gc) {
		//Update all enemies
		((Zombie) enemies[0]).update(gc) ;
		((Zombie) enemies[0]).setRobotPos(robot.getPos());
	}

}
