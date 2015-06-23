package game.objects.weapons.Shotguns;

import java.util.ArrayList;

import game.Position;
import game.objects.weapons.BlasterMissile;
import game.objects.weapons.ShotgunMissile;

import org.newdawn.slick.GameContainer;
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
