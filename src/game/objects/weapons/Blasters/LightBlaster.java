package game.objects.weapons.Blasters;

import game.objects.weapons.BlasterMissile;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LightBlaster extends Blaster {

	public LightBlaster(int place) {
		super(place);

		name = "Light Blaster";
		price = 100;
		power = 1;
		speed = (float) 8;

		missiles = new ArrayList<BlasterMissile>();

		imageInInventoryAddress = ("pics/weapons/image 385.png");

		init();
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
