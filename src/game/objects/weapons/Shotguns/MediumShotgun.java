package game.objects.weapons.Shotguns;

import game.Position;
import game.objects.weapons.MediumShotgunMissile;
import game.objects.weapons.ShotgunMissile;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MediumShotgun extends Shotgun {

	public MediumShotgun(int place){
		super( place ) ;
		
		name = "Medium Shotgun";
		price = 2800;
		power = 3;
		speedRate = (float) 14;

		imageInInventoryAddress = ("pics/weapons/image 168.png");

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
		if (renderControler == speedRate * 40) {
			renderControler = 0;
			missiles.add(new MediumShotgunMissile((float) (angleRad + Math.PI / 2),
					pos1 , 0));
			missiles.add(new MediumShotgunMissile((float) (angleRad + Math.PI / 2),
					pos1 , 1));
			missiles.add(new MediumShotgunMissile((float) (angleRad + Math.PI / 2),
					pos1 , 2));
			missiles.add(new MediumShotgunMissile((float) (angleRad + Math.PI / 2),
					pos1 , 3));
		}

	}
	/**
	 * Loads image
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			imageInInventory = new Image("pics/weapons/image 168.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
