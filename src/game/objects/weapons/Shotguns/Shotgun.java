package game.objects.weapons.Shotguns;

import game.Position;
import game.objects.weapons.ShotgunMissile;
import game.objects.weapons.Weapon;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

public abstract class Shotgun extends Weapon {

	protected ArrayList<ShotgunMissile> missiles;
	
	public Shotgun(int place) {
		// TODO Auto-generated constructor stub
		super( place ) ;
	}
	
	@Override
	public void update(GameContainer gc) {
		// TODO Auto-generated method stub
		for (int i = 0; i < missiles.size(); i++) {
			ShotgunMissile missile2 = (ShotgunMissile) missiles.get(i);
			if (missile2.getPos().getX() < 800 && missile2.getPos().getX() > 0
					&& missile2.getPos().getY() > 0
					&& missile2.getPos().getY() < 600) {
				missile2.update(gc);
			} else {
				missiles.remove(i);
			}
		}
	}
	
	/**
	 * Draw missiles of gun
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		for (ShotgunMissile missile2 : missiles) {
			if (missile2 != null)
				missile2.draw();
		}
	}
}
