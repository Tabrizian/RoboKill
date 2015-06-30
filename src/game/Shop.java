package game;

import game.inventory.Inventory;
import game.inventory.Item;
import game.inventory.ItemDiscription;
import game.inventory.ItemsDatabase;
import game.inventory.OkButton;
import game.objects.AddOne;
import game.objects.weapons.Weapon;
import game.objects.weapons.blasters.LightBlaster;
import game.objects.weapons.shotguns.HeavyShotgun;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Shop {
	private Image inventoryImage;
	private Image robot;
	private Image inventoryText;
	private Position pos;
	/**
	 * Character states.
	 */
	private Image character;
	private String inventoryAddress;
	private String characterAddress;
	private String robotAddress;
	private String inventoryTextAddress;
	private Item[][] itemsTabular;
	private Item[] weapons;
	private Item[] upgrades;
	private Item[][] shopingItems;
	public static Shop instance = null;
	private OkButton ok;
	private boolean isPointedToItem = false;
	private boolean visible = false;
	private ItemDiscription discription;
	

	private Shop() {

		inventoryAddress = "pics/inventory/inventory.png";
		
		robotAddress = "pics/inventory/robot.png";
		inventoryTextAddress = "pics/texts/inventory.png";

		itemsTabular = new Item[7][4];
		itemsTabular = ItemsDatabase.getItemsDatabase().getItemsTabular();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 4; j++) {
				ItemsDatabase.getItemsDatabase().addToTabular(i, j,
						itemsTabular[i][j]);
			}
		}

		weapons = new Item[4];
		weapons = ItemsDatabase.getItemsDatabase().getWeapons();
		for (int i = 0; i < weapons.length; i++) {
			ItemsDatabase.getItemsDatabase().addToWeapons(i, weapons[i]);
		}

		pos = new Position(50, 50);
		discription = new ItemDiscription(new Position(pos.getX() + 50,
				pos.getY() + 45),true);
		
		upgrades = new Item[4];
		upgrades = ItemsDatabase.getItemsDatabase().getUpgrades();
		for (int i = 0; i < upgrades.length; i++) {
			ItemsDatabase.getItemsDatabase().addToUpgrades(i, upgrades[i]);
		}
		
		
		ok = new OkButton("OK",
				new Position(pos.getX() + 265, pos.getY() + 440));
		
		shopingItems = new Item[7][4];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 4; j++) {
				shopingItems[i][j] = new Item("tabular", true);
				shopingItems[i][j].add(new LightBlaster(0, "robot"));
				ItemsDatabase.getItemsDatabase().addToShop(i, j,
						shopingItems[i][j]);
			}
		}
		instance = this; 
		
	}

	public static Shop getShop() {
		if (instance == null)
			new Shop();
		return instance;
	}

	/**
	 * Loads images
	 */
	public void init() {
		try {
			inventoryImage = new Image(inventoryAddress);
		
			robot = new Image(robotAddress);
			inventoryText = new Image(inventoryTextAddress);
			ok.init();
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 4; j++) {
					itemsTabular[i][j].init();
				}
			}
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 4; j++) {
					shopingItems[i][j].init();
				}
			}
			for (Item item : weapons) {
				item.init();
			}
			for (Item item : upgrades) {
				item.init();
			}
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		discription.init();
	}

	/**
	 * This method is for adding a certain addOne to inventory.
	 * 
	 * @param addOne
	 */
	public void add(AddOne addOne, int place) {
		weapons[place].add(addOne);
	}

	/**
	 * Draws images with Graphics g
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setAntiAlias(true);
		inventoryImage.draw(pos.getX(), pos.getX());
		

		robot.draw(pos.getX() + 50, pos.getY() + 200);
		inventoryText.draw(pos.getX() + 343, pos.getY() + 250);
		ok.draw(g);
		ItemsDatabase.getItemsDatabase().drawAll();
		discription.draw(g);
	}

	/**
	 * Updates items
	 * 
	 * @param gc
	 */
	public void update(GameContainer gc) {

		for (Item item1 : weapons) {
			item1.update(gc);
		}

		for (Item item1 : upgrades) {
			item1.update(gc);
		}

		for (Item[] items : itemsTabular) {
			for (Item item1 : items) {
				item1.update(gc);
			}
		}
		
		for (Item[] items : shopingItems) {
			for (Item item1 : items) {
				item1.update(gc);
			}
		}

		ok.update(gc);
		discription.update(gc);
	}

	public Item[] getWeaponsItems() {
		return weapons;
	}

	public void addAddOneToTabular(AddOne addOne) {
		boolean run = true;
		for (int i = 0; i < 7 && run; i++) {
			for (int j = 0; j < 4; j++) {
				if (itemsTabular[i][j].getAddOne() == null) {
					Item item = new Item("tabular", i, j);
					item.add(addOne);
					ItemsDatabase.getItemsDatabase().addToTabular(i, j, item);
					itemsTabular[i][j] = item;
					item.init();
					run = false;
					break;
				}

			}
		}
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
