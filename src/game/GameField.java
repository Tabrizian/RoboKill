package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameField {

	private Cell[][] cells;
	private boolean isCleaned;
	private boolean isActivate;
	private String image;
	private Image fieldImage;

	private UtilityButton map;
	private UtilityButton menu;
	private UtilityButton inv;

	public GameField() {

		image = ("pics/fields/image 187.png");
		map = new UtilityButton("map");
		inv = new UtilityButton("inv");
		menu = new UtilityButton("menu");
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
			map.init();
			menu.init();
			inv.init();
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
		map.draw(g);
		inv.draw(g);
		menu.draw(g);
	}

	public void update(GameContainer gc) {
		map.update(gc);
		inv.update(gc);
		menu.update(gc);
	}

}
