package game.objects.weapons.Blasters;

import game.objects.weapons.BlasterMissile;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MediumBlaster extends Blaster {

	public MediumBlaster(int place){
		super( place ) ;
		
		name = "Medium Blaster" ;
		speed = (float) 6 ;
		price = 2100 ;
		power = 2 ;
		
		missiles = new ArrayList<BlasterMissile>();

		imageInInventoryAddress = ("pics/weapons/image 929.png");

		init();
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
