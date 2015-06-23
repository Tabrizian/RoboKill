package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameField {

	private Cell[][] cells;
	private boolean isCleaned = false;
	private boolean isActivate = true;
	private String image;
	private Image fieldImage;


	public GameField() {

		image = ("pics/fields/image 187.png");
		
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
	}

	/**
	 * Draw image
	 */
	public void draw(Graphics g) {
		fieldImage.draw(0, 0);
		
	}

	public void update(GameContainer gc) {
		
	}

}
