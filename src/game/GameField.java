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
	private GameFieldModel model;

	public GameField() {

		image = ("pics/fields/image 187.png");

	}

	public GameField(GameFieldModel model) {
		this.model = model;
	}

	public String getImage() {
		return image;
	}

	/**
	 * Loads image
	 */
	public void init() {
		if (model == null) {
			try {
				fieldImage = new Image(this.getImage());

			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			model.drawAll();
		}
	}

	/**
	 * Draw image
	 */
	public void draw(Graphics g) {
		if (model == null)
			fieldImage.draw(0, 0);
		else
			model.drawAll();

	}

	public void update(GameContainer gc) {

	}

}
