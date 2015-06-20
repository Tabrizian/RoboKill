package game;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

public class GameField {

	private Cell[][] cells;
	private boolean isCleaned;
	private boolean isActivate;
	private String image;
	private Image fieldImage;

	public GameField() {

		image = ("src/game/images/fields/image 187.png");

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
	public void draw() {
		fieldImage.draw(0, 0);
	}

}
