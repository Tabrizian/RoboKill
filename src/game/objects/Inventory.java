package game.objects;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Inventory {
	private ArrayList<AddOne> addOnes;
	private Image inventoryImage;
	private Image itemDiscr;
	private Image item;
	/**
	 * Character states.
	 */
	private Image character;
	private String inventoryAddress;
	private String itemDiscrAddress;
	private String itemAddress;
	private String characterAddress;
	public static Inventory instance = null;

	private Inventory() {
		addOnes = new ArrayList<AddOne>();
		inventoryAddress = "pics/inventory/inventory.png";
		itemDiscrAddress = "pics/inventory/itemDiscr.png";
		itemAddress = "pics/inventory/item.png";
		characterAddress = "pics/inventory/character.png";
		instance = this;
	}

	public static Inventory getInventory() {
		if (instance == null)
			new Inventory();
		return instance;
	}

	public void init() {
		try {
			inventoryImage = new Image(inventoryAddress);
			itemDiscr = new Image(itemDiscrAddress);
			character = new Image(characterAddress);
			item = new Image(itemAddress);
			for (AddOne addOne : addOnes) {
				addOne.imageInInventory = new Image(
						addOne.imageInInventoryAddress);
			}
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method is for adding a certain addOne to inventory.
	 * 
	 * @param addOne
	 */
	public void add(AddOne addOne) {
		addOnes.add(addOne);
	}

	public void draw() {
		inventoryImage.draw(50, 50);
	}

}
