package game;

import game.objects.weapons.Missile;

import java.util.ArrayList;

public class MisslesDatabase {

	private ArrayList<Missile> missilesRobot;
	private ArrayList<Missile> missilesEnemy;

	private MisslesDatabase() {
		missilesEnemy = new ArrayList<Missile>();
		missilesRobot = new ArrayList<Missile>();
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

	public void explodeArea(Position pos, float width, float height) {
		for (Missile missile : missilesEnemy) {
			if(isInsideArea(pos, width, height, missile.getPos()))
				missile.setExploded(true); 
		}
		
		for (Missile missile : missilesRobot) {
			if(isInsideArea(pos, width, height, missile.getPos()))
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
	private boolean isInsideArea(Position pos, float width, float height,
			Position pos2) {
		return pos2.getX() > pos.getX() && pos2.getX() < (pos.getX() + width)
				&& pos2.getY() > pos.getY()
				&& pos2.getY() < (pos.getY() + height);
	}
}
