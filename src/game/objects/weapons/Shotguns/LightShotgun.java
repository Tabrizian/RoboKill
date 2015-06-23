package game.objects.weapons.Shotguns;

import game.Position;
import game.objects.weapons.LightShotgunMissile;
import game.objects.weapons.ShotgunMissile;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LightShotgun extends Shotgun {

	public LightShotgun( int place ){
		super( place ) ;
		
		name = "Light Shotgun";
		price = 200;
		power = 2;
		speedRate = (float) 19;

		missiles = new ArrayList<ShotgunMissile>();

		imageInInventoryAddress = ("pics/weapons/image 362.png");

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
			missiles.add(new LightShotgunMissile((float) (angleRad + Math.PI / 2),
					pos1 , 0));
			missiles.add(new LightShotgunMissile((float) (angleRad + Math.PI / 2),
					pos1 , 1));
			missiles.add(new LightShotgunMissile((float) (angleRad + Math.PI / 2),
					pos1 , 2));
			missiles.add(new LightShotgunMissile((float) (angleRad + Math.PI / 2),
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
			imageInInventory = new Image("pics/weapons/image 385.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
