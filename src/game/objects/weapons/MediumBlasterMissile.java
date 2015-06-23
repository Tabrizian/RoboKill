package game.objects.weapons;

import game.Position;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MediumBlasterMissile extends BlasterMissile {

	public MediumBlasterMissile(float angle, Position pos) {
		super(angle, pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		try {
			img = new Image("pics/fires/image 877.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
