package game;

import game.objects.Robot;
import game.objects.enemies.Enemy;
import game.objects.enemies.Sagehar;
import game.objects.enemies.Vahshi;
import game.objects.enemies.Zombie;

import java.util.ArrayList;

public class EnemiesDatabase {

	private ArrayList<Enemy> enemies;
	private static EnemiesDatabase instance = null;
	private GameField current = null;

	private EnemiesDatabase() {
		enemies = new ArrayList<Enemy>();
		instance = this;
	}

	public static EnemiesDatabase getEnemiesDatabase() {
		if (instance == null) {
			new EnemiesDatabase();
		}
		return instance;
	}

	public void add(Enemy enemy) {
		enemies.add(enemy);
	}

	public void remove(Enemy enemy) {
		enemies.remove(enemy);
	}

	public boolean enemyCollidedWithRobot() {
		if (Map.getMap().getActiveGameField() != current) {
			current = Map.getMap().getActiveGameField();
			enemies.clear();
			for (int i = 0; i < current.getEnemies().length; i++) {
				enemies.add(current.getEnemies()[i]);
			}
		}
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if (enemy instanceof Sagehar) {
				if (twoAreasCollided(new Position(enemy.getPos().getX() - 24,
						enemy.getPos().getY() - 24), 48, 48, new Position(Robot
						.getRobot().getPos().getX() - 22.5f, Robot.getRobot()
						.getPos().getY() - 22.5f), 45, 45)) {
					enemy.setHealth(0);
					if (enemy.getDestroyDamage() > Robot.getRobot().getHealth()) {
						Robot.getRobot().setHealth(0);
					} else {
						Robot.getRobot().setHealth(
								Robot.getRobot().getHealth()
										- enemy.getDestroyDamage());
					}
					enemies.remove(enemy);
					System.out.println("Collided!!");
					return true;
				}
			} else if (enemy instanceof Zombie) {
				if (twoAreasCollided(new Position(enemy.getPos().getX() - 22.5f,
						enemy.getPos().getY() - 22.5f), 45, 45, new Position(Robot
						.getRobot().getPos().getX() - 22.5f, Robot.getRobot()
						.getPos().getY() - 22.5f), 45, 45)) {
					enemy.setHealth(0);
					if (enemy.getDestroyDamage() > Robot.getRobot().getHealth()) {
						Robot.getRobot().setHealth(0);
					} else {
						Robot.getRobot().setHealth(
								Robot.getRobot().getHealth()
										- enemy.getDestroyDamage());
					}
					enemies.remove(enemy);
					System.out.println("Collided!!");
					return true;
				}

			} else if (enemy instanceof Vahshi) {
				if (twoAreasCollided(new Position(enemy.getPos().getX() - 15,
						enemy.getPos().getY() - 15), 30, 30, new Position(Robot
						.getRobot().getPos().getX() - 22.5f, Robot.getRobot()
						.getPos().getY() - 22.5f), 45, 45)) {
					enemy.setHealth(0);
					if (enemy.getDestroyDamage() > Robot.getRobot().getHealth()) {
						Robot.getRobot().setHealth(0);
					} else {
						Robot.getRobot().setHealth(
								Robot.getRobot().getHealth()
										- enemy.getDestroyDamage());
					}
					enemies.remove(enemy);
					System.out.println("Collided!!");
					return true;
				}
			}
		}

		return false;
	}

	public boolean twoAreasCollided(Position pos1, int height1, int width1,
			Position pos2, int height2, int width2) {
		if (isInsideArea(pos1, width1, width1, pos2)
				|| isInsideArea(pos1, width1, width1, new Position(pos2.getX()
						+ width2, pos2.getY()))
				|| isInsideArea(pos1, width1, width1, new Position(pos2.getX()
						+ width2, pos2.getY() + height2))
				|| isInsideArea(pos1, width1, width1, new Position(pos2.getX(),
						pos2.getY() + height2))) {
			return true;
		}
		return false;
	}

	public boolean isInsideArea(Position pos, int height, int width,
			Position pos2) {
		return pos2.getX() > pos.getX() && pos2.getX() < (pos.getX() + width)
				&& pos2.getY() > pos.getY()
				&& pos2.getY() < (pos.getY() + height);

	}

}
