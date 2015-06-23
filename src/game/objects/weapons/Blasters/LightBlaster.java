package game.objects.weapons.Blasters;

import game.Position;
import game.objects.weapons.BlasterMissile;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LightBlaster extends Blaster {

	// Controls rendering for missiles
	private long renderControler = 0;

	private ArrayList<BlasterMissile> missiles;

	public LightBlaster(int place) {
		super(place);

		name = "Light Blaster";
		price = 100;
		power = 1;
		speed = (float) 5;

		missiles = new ArrayList<BlasterMissile>();

		imageInInventoryAddress = ("pics/weapons/image 385.png");

		init();
	}

	@Override
	public void shot(float angleRad, Position pos, int robotWidth ) {
		// TODO Auto-generated method stub

		//determine initial missile position
		Position pos1 = new Position(pos);
		if (place == 0) {
			pos1.setX((float) (pos1.getX() - (float) (robotWidth / 2)
					* Math.cos(angleRad)));
			pos1.setY((float) (pos1.getY() - (float) (robotWidth / 2)
					* Math.sin(angleRad)));
		} else if (place == 1) {
			pos1.setX((float) (pos1.getX() - (float) (robotWidth / 4)
					* Math.cos(angleRad)));
			pos1.setY((float) (pos1.getY() - (float) (robotWidth / 4)
					* Math.sin(angleRad)));
		} else if (place == 2) {
			pos1.setX((float) (pos1.getX() + (float) (robotWidth / 4)
					* Math.cos(angleRad)));
			pos1.setY((float) (pos1.getY() + (float) (robotWidth / 4)
					* Math.sin(angleRad)));
		} else if (place == 3) {
			pos1.setX((float) (pos1.getX() + (float) (robotWidth / 2)
					* Math.cos(angleRad)));
			pos1.setY((float) (pos1.getY() + (float) (robotWidth / 2)
					* Math.sin(angleRad)));
		}

		renderControler++;
		if (renderControler == speed * 40) {
			renderControler = 0;
			missiles.add(new BlasterMissile((float) (angleRad + Math.PI / 2),
					pos1));
		}

	}

	@Override
	public void update(GameContainer gc) {
		// TODO Auto-generated method stub
		for (int i = 0; i < missiles.size(); i++) {
			BlasterMissile missile2 = (BlasterMissile) missiles.get(i);
			if (missile2.getPos().getX() < 800 && missile2.getPos().getX() > 0
					&& missile2.getPos().getY() > 0
					&& missile2.getPos().getY() < 600) {
				missile2.update(gc);
			} else {
				missiles.remove(i);
			}
		}
	}

	/**
	 * Draw missiles of gun
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		for (BlasterMissile missile2 : missiles) {
			if (missile2 != null)
				missile2.draw();
		}
	}

	/**
	 * Loads image
	 */
	@Override
	public void init() {
		try {
			imageInInventory = new Image("pics/weapons/image 385.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
