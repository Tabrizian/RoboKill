package game.objects.weapons.Blasters;

import game.Position;
import game.objects.weapons.BlasterMissile;
import game.objects.weapons.Missile;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LightBlaster extends Blaster {

	// Controls rendering for missiles
	private long renderControler = 0;
	
	private ArrayList<BlasterMissile> missiles ;
	
	public LightBlaster() {
		super();

		name = "Light Blaster";
		price = 100;
		power = 1;
		speed = 5;

		missiles = new ArrayList<BlasterMissile>();
		
		imageInFieldAddress = ("src/game/images/weapons/image 403.png") ;
		imageInInventoryAddress = ("src/game/images/weapons/image 385.png") ;
		
		//init() ;
	}

	@Override
	public void shot(float angleRad , Position pos ) {
		// TODO Auto-generated method stub
		renderControler++;
		if (renderControler == 110) {
			renderControler = 0;
			missiles.add(new BlasterMissile((float) (angleRad + Math.PI / 2), pos));
		}

	}

	@Override
	public void update(GameContainer gc) {
		// TODO Auto-generated method stub
		for (int i = 0; i < missiles.size(); i++) {
			BlasterMissile missile2 = (BlasterMissile) missiles.get(i);
			if (missile2.getPos().getX() < 800 && missile2.getPos().getX() > 0
					&& missile2.getPos().getY() > 0
					&& missile2.getPos().getY() < 600) {
				missile2.update(gc);
			} else {
				missiles.remove(i);
			}
		}
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
		for (BlasterMissile missile2 : missiles) {
			if (missile2 != null)
				missile2.draw();
		}
	}

	/**
	 * Loads image
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			imageInField = new Image(this.getImageInFieldAddress()) ;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			imageInInventory = new Image(this.getImageInInventoryAddress()) ;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
