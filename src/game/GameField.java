package game;

import game.cells.Cell;

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

	public GameField() {

		image = ("pics/fields/image 187.png");

	}

	public GameField(GameFieldModel model) {
		image = ("pics/fields/image 593.jpg");
		suround = ("pics/fields/image 743.png") ;
		this.model = model;
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

	}

	/**
	 * Draw image
	 */
	public void draw(Graphics g) {

		fieldImage.draw(0, 0);

		model.drawAll();
		
		suroundImage.draw(0, 0);

	}

	public void update(GameContainer gc) {

	}

}
