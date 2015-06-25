package game;

import game.inventory.Inventory;
import game.objects.Robot;
import game.objects.weapons.Blasters.LightBlaster;
import game.objects.weapons.Blasters.MediumBlaster;
import game.objects.weapons.Shotguns.HeavyShotgun;
import game.objects.weapons.Shotguns.LightShotgun;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Map {

	/**
	 * Rooms
	 */
	private GameField[][] fields;
	/**
	 * The robot
	 */
	private Robot robot;
	/**
	 * Player who controls robot
	 */
	private Player player;
	/**
	 * An instance of the map
	 */
	private static Map instance;

	private Map() {
		instance = this;
		fields = new GameField[5][5];

		robot = Robot.getRobot();

		// Create fields
		Cell[][] cells = new Cell[15][11];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 11; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
		GameFieldModel model = new GameFieldModel(cells);
		fields[4][1] = new GameField(model, 1, robot);

	}

	/**
	 * A method that return a unique map
	 * 
	 * @return
	 */
	public static Map getMap() {
		if (instance == null)
			new Map();
		return instance;
	}

	/**
	 * Loads images for components
	 */
	public void init() {
		robot.init();
		fields[4][1].init();

		HeavyShotgun heavyShotgun = new HeavyShotgun(0);
		MediumBlaster MediumBlaster = new MediumBlaster(3);
		LightBlaster lightBlaster = new LightBlaster(1);
		LightShotgun lightShotgun = new LightShotgun(2);

		// Adding light shotgun to inventory for test.
		Inventory.getInventory().add(heavyShotgun, 0);
		Inventory.getInventory().add(MediumBlaster, 3);
		Inventory.getInventory().add(lightBlaster, 1);
		Inventory.getInventory().add(lightShotgun, 2);
		robot.addGun(heavyShotgun, 0);
		robot.addGun(lightBlaster, 1);
		robot.addGun(MediumBlaster, 3);
		robot.addGun(lightShotgun, 2);
	}

	/**
	 * Draw the robot and field that is activated with Graphics g
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		fields[4][1].draw(g);
		robot.draw();
	}

	/**
	 * Update the robot and field that is activated in gc
	 * 
	 * @param gc
	 */
	public void update(GameContainer gc) {
		robot.update(gc);
		fields[4][1].update(gc);
	}

	/**
	 * Draw the map in scope mode when map key is pressed
	 */
	public void drawInScopeMode() {

	}
}
