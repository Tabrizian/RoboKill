package game;

import org.newdawn.slick.SlickException;

public class GameField {

	private Cell[][] cells;
	private boolean isCleaned;
	private boolean isActivate;
	private String image;

	public GameField() {

		image = ("src/game/images/fields/image 187.png");

	}

	public String getImage() {
		return image;
	}

}
