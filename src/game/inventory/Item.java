package game.inventory;

import game.Player;
import game.Position;
import game.objects.AddOne;
import game.objects.prizes.Plunder;
import game.objects.weapons.Weapon;

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
	private static int population2 = 0;
	private boolean lifted = false;

	public Item(String name) {
		itemAddress = "pics/inventory/item.png";
		pos = new Position(400 + (population % 7) * 40,
				310 + population / 7 * 40);
		defaultPos = new Position(pos);
		this.name = name;
		population++;

	}

	public Item(String name, boolean isShop) {
		itemAddress = "pics/inventory/item.png";
		pos = new Position(393 + (population2 % 7) * 40,
				90 + population2 / 7 * 40);
		defaultPos = new Position(pos);
		this.name = name;
		population2++;
	}

	public Item(Position pos, String name) {
		itemAddress = "pics/inventory/item.png";
		defaultPos = new Position(pos);
		this.pos = pos;
		this.name = name;
	}

	public Item(String name, int row, int col) {
		itemAddress = "pics/inventory/item.png";
		int num = row * 7 + col;
		pos = new Position(400 + (num % 7) * 40, 310 + num / 7 * 40);
		this.name = name;
		defaultPos = new Position(pos);
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
					if(ItemsDatabase.getItemsDatabase().isInsideShop(this)){
						
						if (addOne instanceof Weapon) {
							Weapon weapon = (Weapon) addOne;
							if (Player.getPlayer().getCash() >= weapon.getPrice()){
								Player.getPlayer().setCash(Player.getPlayer().getCash() - weapon.getPrice());
								
								item.add(addOne);
								addOne = null;
							}
						}
					}
					else if (item.getName().equals("upgrade")) {
						if (addOne instanceof Plunder) {
							item.add(addOne);
							addOne = null;
						}
					} else {
						item.add(addOne);
						addOne = null;
					}
				}
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
	 * 
	 * @param addOne
	 */
	public void add(AddOne addOne) {
		this.addOne = addOne;
	}

	/**
	 * Returns true if this item is lifted by mouse
	 * 
	 * @return
	 */
	public boolean isLifted() {
		return lifted;
	}

	/**
	 * Getter for addOne
	 * 
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

	public String getName() {
		return name;
	}

}
