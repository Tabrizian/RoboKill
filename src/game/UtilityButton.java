package game;

import game.inventory.Inventory;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class UtilityButton {

	private Image img;
	private static int population = 0;
	private String imgAddress;
	private String name;
	private Position pos;
	private boolean focused = false;
	private Inventory inventory;
	private static boolean showInventory = false;

	private Image[] frames;
	private Animation s;

	private boolean isAnimationDrawe = false;

	public UtilityButton(String name) {
		this.name = name;
		pos = new Position(665 + population * 45, 590);

		imgAddress = "pics/buttons/" + name + ".png";
		population++;

		frames = new Image[46];

		inventory = Inventory.getInventory();
	}

	public void init() {
		inventory.init();
		try {
			img = new Image(imgAddress);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 1; i <= 46; i++) {
			String s = Integer.toString(i);
			try {
				frames[i - 1] = new Image("pics/inventory/" + s + ".png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		s = new Animation(frames, 15);

		s.setLooping(false);
	}

	public void draw(Graphics g) {
		img.draw(pos.getX(), pos.getY());
		if (focused)
			g.drawRect(pos.getX(), pos.getY(), 45, 13);
		if (showInventory)

			inventory.draw(g);


	}

	public void update(GameContainer gc) {
		Input input = gc.getInput();

		float mX = input.getMouseX();
		float mY = input.getMouseY();
		inventory.update(gc);

		if (mX > pos.getX() && mX < (pos.getX() + 45) && mY < (pos.getY() + 13)
				&& mY > pos.getY()) {
			focused = true;
			if (input.isMousePressed(0)) {
				switch (name) {
				case "inv":
					showInventory = !showInventory;
					break;
				}
			}
		} else
			focused = false;

	}
	
	public static void setInventoryState(boolean show){
		showInventory = show;
	}
}
