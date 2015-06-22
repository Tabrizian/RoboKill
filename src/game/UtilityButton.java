package game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class UtilityButton {

	private Image img;
	private static int population = 0;
	private String imgAddress;
	private String name;
	private Position pos;

	public UtilityButton(String name) {
		this.name = name;
		pos = new Position(665 + population * 45, 590);

		imgAddress = "pics/buttons/" + name + ".png";
		population++;
	}

	public void init() {
		try {
			img = new Image(imgAddress);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw() {
		img.draw(pos.getX(), pos.getY());
	}
}
