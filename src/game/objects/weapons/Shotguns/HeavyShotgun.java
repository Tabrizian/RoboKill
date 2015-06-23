package game.objects.weapons.Shotguns;

import java.util.ArrayList;

import game.Position;
import game.objects.weapons.ShotgunMissile;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HeavyShotgun extends Shotgun {

	public HeavyShotgun(int place ){
		super(place) ;
		
		name = "Heavy Shotgun";
		price = 4200;
		power = 4;
		speedRate = (float) 9;

		missiles = new ArrayList<ShotgunMissile>();

		imageInInventoryAddress = ("pics/weapons/image 348.png");

		init();
	}
	/**
	 * Loads image
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			imageInInventory = new Image("pics/weapons/image 348.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
