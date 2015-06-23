package game;

import game.objects.AddOne;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Item {

	private Image itemImage;
	private String itemAddress;
	private String name;
	private Position pos;
	private AddOne addOne = null;
	private static int population = 0;

	public Item() {
		itemAddress = "pics/inventory/item.png";
		pos = new Position(400 + (population % 7) * 40,
				310 + population / 7 * 40);
		population++;
	}

	public Item(Position pos) {
		itemAddress = "pics/inventory/item.png";
		this.pos = pos;
	}

	public void init() {
		try {
			itemImage = new Image(itemAddress);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw() {
		if (addOne == null)
			itemImage.draw(pos.getX(), pos.getY());
		else
			addOne.getImageInInventory().draw(pos.getX(), pos.getY());
	}

	public void update(GameContainer gc) {
		Input input = gc.getInput();
	}

	public void add(AddOne addOne) {
		this.addOne = addOne;
	}

}
