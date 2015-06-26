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
		//Preparing environment
		image = ("pics/fields/image 593.jpg");
		suround = ("pics/fields/image 743.png") ;
		this.model = model;
		this.robot = robot ;
		
		//Create enemies for this field
		enemies = new Enemy[numOfEnemies] ;
		enemies[0] = new Zombie(robot.getPos() , new Position(300, 300) , this) ;
	}

	/**
	 * Getter for background of the field
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
		
		//Initialize all enemies
		((Zombie) enemies[0]).init() ;

	}

	/**
	 * Draw the field
	 */
	public void draw(Graphics g) {

		fieldImage.draw(0, 0);

		model.drawAll();
		
		suroundImage.draw(0, 0);
		
		if( this.getModel().getHasExitText() == true)
			this.getModel().getExitText().draw(350, 65);
		//Draw all enemies
		((Zombie) enemies[0]).draw() ;

	}
	/**
	 * Updates enemies in game container gc
	 * @param gc
	 */
	public void update(GameContainer gc) {
		//Update all enemies
		((Zombie) enemies[0]).update(gc) ;
		((Zombie) enemies[0]).setRobotPos(robot.getPos());
	}
	/**
	 * Getter for model of the field
	 * @return
	 */
	public GameFieldModel getModel(){
		return model ;
	}
	/**
	 * Check that this position is not blocked by a certain cell
	 * @param pos
	 * @return false if is not blocked and true in otherwise
	 */
	public boolean isValidPos( Position pos ){
		if( model.getCellWithPos(pos.getX() , pos.getY() ).getIsBlocked() )
			return false;
		return true ;
	}
}
