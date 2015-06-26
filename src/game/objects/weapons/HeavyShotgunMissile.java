package game.objects.weapons;

import game.Position;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HeavyShotgunMissile extends ShotgunMissile {

	public HeavyShotgunMissile(float angle, Position pos, int num, String owner) {
		super(angle, pos, num, owner);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initialize missile
	 */
	@Override
	public void init() {
		try {
			img = new Image("pics/fires/image 377.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
