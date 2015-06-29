package game.objects.weapons;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.Position;

public class LightShotgunMissile extends ShotgunMissile {

	public LightShotgunMissile(float angle, Position pos, int num,
			String owner, int damage) {
		super(angle, pos, num, owner, damage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initialize missile
	 */
	@Override
	public void init() {
		try {
			img = new Image("pics/fires/image 708.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
