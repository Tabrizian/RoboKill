package game.objects.weapons;

import game.Position;

import java.util.ArrayList;

public class MissilesDatabase {

	private ArrayList<Missile> missilesRobot;
	private ArrayList<Missile> missilesEnemy;
	private static MissilesDatabase instance = null;

	private MissilesDatabase() {
		missilesEnemy = new ArrayList<Missile>();
		missilesRobot = new ArrayList<Missile>();
		instance = this;
	}

	public static MissilesDatabase getMissilesDatabase() {
		if (instance == null) {
			new MissilesDatabase();
		}
		return instance;
	}

	public void addMissleEnemy(Missile missile) {
		missilesEnemy.add(missile);
	}

	public void addMissleRobot(Missile missile) {
		missilesRobot.add(missile);
	}

	public boolean isEnemyMissileInsideArea(Position pos, float width,
			float height) {
		for (Missile missile : missilesEnemy) {
			if (isInsideArea(pos, width, height, missile.getPos()))
				return true;
		}
		return false;
	}

	public boolean isRobotMissileInsideArea(Position pos, float width,
			float height) {
		for (Missile missile : missilesRobot) {
			if (isInsideArea(pos, width, height, missile.getPos()))
				return true;
		}
		return false;
	}

	public void explodeAreaForRobot(Position pos, float width, float height) {
		for (Missile missile : missilesEnemy) {
			if (isInsideArea(pos, width, height, missile.getPos()))
				missile.setExploded(true);
		}
	}

	public void explodeAreaForEnemy(Position pos, float width, float height) {
		for (Missile missile : missilesRobot) {
			if (isInsideArea(pos, width, height, missile.getPos()))
				missile.setExploded(true);
		}
	}

	/**
	 * Determines whether the pos2 is inside area with corner pos and width and
	 * height that is specified.
	 * 
	 * @param pos
	 * @param width
	 * @param height
	 * @param pos2
	 * @return
	 */
	public boolean isInsideArea(Position pos, float width, float height,
			Position pos2) {
		return pos2.getX() > pos.getX() && pos2.getX() < (pos.getX() + width)
				&& pos2.getY() > pos.getY()
				&& pos2.getY() < (pos.getY() + height);
	}

	public void addMissile(Missile missile) {
		if (missile.getOwner().equals("robot"))
			addMissleRobot(missile);
		else
			addMissleEnemy(missile);
	}

	public void removeMissile(Missile missile) {
		if (missilesEnemy.contains(missile)) {
			missilesEnemy.remove(missile);
		} else {
			missilesRobot.remove(missile);
		}
	}

	public void explodeForCells(Position pos, float width, float height) {
		for (Missile missile : missilesRobot) {
			if (isInsideArea(pos, width, height, missile.getPos()))
				missile.setExploded(true);
		}
		for (Missile missile : missilesEnemy) {
			if (isInsideArea(pos, width, height, missile.getPos()))
				missile.setExploded(true);
		}
	}
	
}
