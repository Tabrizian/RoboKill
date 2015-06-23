package game.objects.weapons.Blasters;

import game.Position;
import game.objects.weapons.BlasterMissile;
import game.objects.weapons.Weapon;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;

public abstract class Blaster extends Weapon {

	protected ArrayList<BlasterMissile> missiles;
	
	public Blaster(int place) {
		// TODO Auto-generated constructor stub
		super(place) ;
	}
	
	@Override
	public void shot(float angleRad, Position pos, int robotWidth ) {
		// TODO Auto-generated method stub

		//determine initial missile position
		Position pos1 = new Position(pos);
		if (place == 0) {
			pos1.setX((float) (pos1.getX() - (float) (robotWidth / 2)
					* Math.cos(angleRad)));
			pos1.setY((float) (pos1.getY() - (float) (robotWidth / 2)
					* Math.sin(angleRad)));
		} else if (place == 1) {
			pos1.setX((float) (pos1.getX() - (float) (robotWidth / 4)
					* Math.cos(angleRad)));
			pos1.setY((float) (pos1.getY() - (float) (robotWidth / 4)
					* Math.sin(angleRad)));
		} else if (place == 2) {
			pos1.setX((float) (pos1.getX() + (float) (robotWidth / 4)
					* Math.cos(angleRad)));
			pos1.setY((float) (pos1.getY() + (float) (robotWidth / 4)
					* Math.sin(angleRad)));
		} else if (place == 3) {
			pos1.setX((float) (pos1.getX() + (float) (robotWidth / 2)
					* Math.cos(angleRad)));
			pos1.setY((float) (pos1.getY() + (float) (robotWidth / 2)
					* Math.sin(angleRad)));
		}

		renderControler++;
		if (renderControler == speedRate * 40) {
			renderControler = 0;
			missiles.add(new BlasterMissile((float) (angleRad + Math.PI / 2),
					pos1));
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
	
	/**
	 * Draw missiles of gun
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		for (BlasterMissile missile2 : missiles) {
			if (missile2 != null)
				missile2.draw();
		}
	}
}
