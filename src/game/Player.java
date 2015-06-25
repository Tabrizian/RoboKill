package game;

import game.objects.Robot;

public class Player {

	private int cash = 0;
	private String name;
	private Robot robot;
	private static Player instance = null;

	private Player(String name) {
		this.name = name;
		robot = Robot.getRobot();
		instance = this;
	}

	public static Player getPlayer(String name) {
		if (instance == null) {
			new Player(name);
		}
		return instance;
	}
}
