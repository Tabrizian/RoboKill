package game.objects.weapons.blasters;

import game.Position;
import game.objects.weapons.LightBlasterMissile;
import game.objects.weapons.Missile;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LightBlaster extends Blaster {

	public LightBlaster(int place, String owner) {
		super(place, owner);

		name = "Light Blaster";
		price = 100;
		power = 1;
		speedRate = (float) 8;

		imageInInventoryAddress = ("pics/weapons/image 385.png");

		init();
	}

	@Override
	public void shot(float angleRad, Position pos, int robotWidth) {
		// TODO Auto-generated method stub

		// determine initial missile position
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
		if (renderControler == speedRate * 40) {
			renderControler = 0;
			missiles.add(new LightBlasterMissile(
					(float) (angleRad + Math.PI / 2), pos1, owner,power));
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
