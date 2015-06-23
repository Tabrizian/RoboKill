package game.objects.weapons.Blasters;

import game.Position;
import game.objects.weapons.BlasterMissile;
import game.objects.weapons.MediumBlasterMissile;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MediumBlaster extends Blaster {

	public MediumBlaster(int place){
		super( place ) ;
		
		name = "Medium Blaster" ;
		speedRate = (float) 6 ;
		price = 2100 ;
		power = 2 ;
		
		missiles = new ArrayList<BlasterMissile>();

		imageInInventoryAddress = ("pics/weapons/image 929.png");

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
			missiles.add(new MediumBlasterMissile((float) (angleRad + Math.PI / 2),
					pos1));
		}

	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			imageInInventory = new Image("pics/weapons/image 929.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
