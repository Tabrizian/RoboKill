package game.inventory;

import game.Position;
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
	private Position defaultPos;
	private AddOne addOne = null;
	private static int population = 0;
	private boolean lifted = false;

	public Item() {
		itemAddress = "pics/inventory/item.png";
		pos = new Position(400 + (population % 7) * 40,
				310 + population / 7 * 40);
		defaultPos = new Position(pos);
		population++;

	}

	public Item(Position pos) {
		itemAddress = "pics/inventory/item.png";
		defaultPos = new Position(pos);
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

		if (!lifted) {
			if (addOne == null)
				itemImage.draw(pos.getX(), pos.getY());
			else
				addOne.getImageInInventory().draw(pos.getX(), pos.getY());
		} else {
			itemImage.draw(defaultPos.getX(), defaultPos.getY());
			if (addOne != null)
				addOne.getImageInInventory().draw(pos.getX(), pos.getY());
		}

	}

	public void update(GameContainer gc) {
		Input input = gc.getInput();
		if (!lifted) {
			pos = new Position(defaultPos);
			if (input.isMouseButtonDown(0)) {
				if (isInside(new Position(input.getMouseX(), input.getMouseY()))) {
					if (!ItemsDatabase.getItemsDatabase().isAnyOneLifted())
						lifted = true;
				}
			}
		}
		if (!input.isMouseButtonDown(0) && lifted) {
			Item item = ItemsDatabase.getItemsDatabase().thePointed(
					new Position(input.getMouseX(), input.getMouseY()));
			if (item != null) {
				if (addOne != null) {
					item.add(addOne);
				}
				addOne = null;
			}
			lifted = false;
		}
		if (lifted) {
			pos.setX(input.getMouseX());
			pos.setY(input.getMouseY());
		}
	}
	/**
	 * Adds a addOne to the item
	 * @param addOne
	 */
	public void add(AddOne addOne) {
		this.addOne = addOne;
	}
	/**
	 * Returns true if this item is lifted by mouse
	 * @return
	 */
	public boolean isLifted() {
		return lifted;
	}
	/**
	 * Getter for addOne
	 * @return
	 */
	public AddOne getAddOne() {
		return addOne;
	}

	public boolean isInside(Position position) {
		return position.getX() < (defaultPos.getX() + 40)
				&& position.getX() > defaultPos.getX()
				&& position.getY() < (defaultPos.getY() + 40)
				&& position.getY() > defaultPos.getY();
	}

}
