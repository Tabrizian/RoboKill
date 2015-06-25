package game.inventory;

import game.Position;
import game.objects.AddOne;
import game.objects.weapons.Weapon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Inventory {
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

	public static Inventory instance = null;
	private OkButton ok;
	private boolean isPointedToItem = false;
	private ItemDiscription discription;
	private boolean isDrawAnimation = false;

	private Inventory() {

		inventoryAddress = "pics/inventory/inventory.png";
		characterAddress = "pics/inventory/character.png";
		robotAddress = "pics/inventory/robot.png";
		inventoryTextAddress = "pics/texts/inventory.png";

		itemsTabular = new Item[7][4];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 4; j++) {
				itemsTabular[i][j] = new Item();
				ItemsDatabase.getItemsDatabase().addToTabular(i, j,
						itemsTabular[i][j]);
			}
		}


		weapons = new Item[4];
		weapons[1] = new Item(new Position(175, 270));
		weapons[2] = new Item(new Position(230, 270));
		weapons[0] = new Item(new Position(105, 360));
		weapons[3] = new Item(new Position(300, 360));
		for (int i = 0; i < weapons.length; i++) {
			ItemsDatabase.getItemsDatabase().addToWeapons(i, weapons[i]);
		}

		pos = new Position(50, 50);
		discription = new ItemDiscription(new Position(pos.getX() + 343,
				pos.getY() + 45));
		instance = this;

		ok = new OkButton("OK",
				new Position(pos.getX() + 265, pos.getY() + 440));
	}

	public static Inventory getInventory() {
		if (instance == null)
			new Inventory();
		return instance;
	}

	public void init() {
		try {
			inventoryImage = new Image(inventoryAddress);
			character = new Image(characterAddress);
			robot = new Image(robotAddress);
			inventoryText = new Image(inventoryTextAddress);
			ok.init();
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 4; j++) {
					itemsTabular[i][j].init();
				}
			}
			for (Item item : weapons) {
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

	public void draw(Graphics g) {
		inventoryImage.draw(pos.getX(), pos.getX());
		character.draw(pos.getX() + 50, pos.getY() + 45);

		robot.draw(pos.getX() + 50, pos.getY() + 200);
		inventoryText.draw(pos.getX() + 343, pos.getY() + 250);
		ok.draw(g);
		ItemsDatabase.getItemsDatabase().drawAll();
		discription.draw(g);
	}

	public void update(GameContainer gc) {
		
		for (Item item1 : weapons) {
			item1.update(gc);
		}

		for (Item[] items : itemsTabular) {
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

	public boolean negativIsDrawAnimation() {
		if (isDrawAnimation == false)
			isDrawAnimation = true;
		else
			isDrawAnimation = false;
		return isDrawAnimation;
	}
}
