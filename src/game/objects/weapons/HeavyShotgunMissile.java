package game.objects.weapons;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.Position;

public class HeavyShotgunMissile extends ShotgunMissile {

	public HeavyShotgunMissile(float angle, Position pos, int num) {
		super(angle, pos, num);
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
