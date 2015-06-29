package game.objects.weapons;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.Position;

public class HeavyBlasterMissile extends BlasterMissile {

	public HeavyBlasterMissile(float angle, Position pos, String owner,int damage) {
		super(angle, pos, owner, damage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		try {
			img = new Image("pics/fires/image 294.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
