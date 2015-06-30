package game.inventory;

import java.awt.Font;

import game.Position;
import game.objects.weapons.Weapon;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class ItemDiscription {
	private String imageAddress;
	private String secondImageAddress;
	private Image image;
	private Image image2;
	private Item currentItem;
	private TrueTypeFont font;
	private Position pos;
	private static Color blue = new Color(0, 253, 253);
	private static Color yellow = new Color(255, 170, 0);
	private boolean isShop = false;

	public ItemDiscription(Position pos) {
		imageAddress = "pics/inventory/itemDiscr.png";
		this.pos = pos;
		secondImageAddress = "pics/inventory/itemDiscr2.png";
	}

	public ItemDiscription(Position pos, boolean isShop) {
		imageAddress = "pics/inventory/itemDiscr.png";
		this.pos = pos;
		this.isShop = isShop;
		secondImageAddress = "pics/inventory/itemDiscr2.png";
	}

	public void init() {
		try {
			image = new Image(imageAddress);
			image2 = new Image(secondImageAddress);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Font awtFont = new Font("Verdana", Font.PLAIN, 10);
		font = new TrueTypeFont(awtFont, true);
	}

	public void draw(Graphics g) {
		if (!isShop) {
			image.draw(pos.getX(), pos.getY());
		} else {
			image2.draw(pos.getX(), pos.getY());
		}
		if (currentItem != null) {
			if (currentItem.getAddOne() instanceof Weapon) {
				Weapon weapon = (Weapon) currentItem.getAddOne();
				font.drawString(pos.getX() + 20, pos.getY() + 25, "WEAPON:",
						yellow);
				font.drawString(pos.getX() + 150, pos.getY() + 25, weapon
						.getName().toUpperCase(), yellow);
				font.drawString(pos.getX() + 20, pos.getY() + 85, "POWER:",
						blue);
				font.drawString(pos.getX() + 150, pos.getY() + 85,
						String.valueOf(weapon.getPower()), blue);
				font.drawString(pos.getX() + 20, pos.getY() + 105, "VALUE:",
						yellow);
				font.drawString(pos.getX() + 150, pos.getY() + 105, "$"
						+ String.valueOf(weapon.getPrice()), yellow);
				font.drawString(pos.getX() + 20, pos.getY() + 125,
						"RATE OF FIRE:", blue);
				font.drawString(pos.getX() + 150, pos.getY() + 125,
						String.valueOf(weapon.getSpeedRate()) + " PER SECOND",
						blue);
			}
		}
	}

	public void update(GameContainer gc) {
		Input input = gc.getInput();
		int mX = input.getMouseX();
		int mY = input.getMouseY();
		Item item = ItemsDatabase.getItemsDatabase().thePointed(
				new Position(mX, mY));
		currentItem = item;

	}

}
