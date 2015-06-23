package game.objects.weapons.Blasters;

import game.objects.weapons.BlasterMissile;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HeavyBlaster extends Blaster {

	public HeavyBlaster(int place) {
		super(place);

		name = "Heavy Blaster";
		speed = (float) 4;
		power = 3;
		price = 3500;

		missiles = new ArrayList<BlasterMissile>();

		imageInInventoryAddress = ("pics/weapons/image 240.png");

		init();
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			imageInInventory = new Image("pics/weapons/image 240.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
