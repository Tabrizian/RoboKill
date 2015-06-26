package game.objects.weapons;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.Position;

public class MediumShotgunMissile extends ShotgunMissile {

	public MediumShotgunMissile(float angle, Position pos, int num, String owner) {
		super(angle, pos, num, owner);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initialize missile
	 */
	@Override
	public void init() {
		try {
			img = new Image("pics/fires/image 693.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
