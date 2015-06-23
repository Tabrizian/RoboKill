package game.objects.weapons.Shotguns;

import java.util.ArrayList;

import game.Position;
import game.objects.weapons.ShotgunMissile;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MediumShotgun extends Shotgun {

	public MediumShotgun(int place){
		super( place ) ;
		
		name = "Medium Shotgun";
		price = 2800;
		power = 3;
		speedRate = (float) 14;

		missiles = new ArrayList<ShotgunMissile>();

		imageInInventoryAddress = ("pics/weapons/image 168.png");

		init();
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
