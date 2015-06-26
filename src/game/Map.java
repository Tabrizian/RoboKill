package game;

import java.util.Random;

import game.cells.Cell;
import game.cells.DownCell;
import game.cells.DownLeftCell;
import game.cells.LeftCell;
import game.cells.SimpleCell;
import game.inventory.Inventory;
import game.objects.Box;
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
	 * An instance of the map
	 */
	private static Map instance;

	private Map() {
		instance = this;
		fields = new GameField[5][5];
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
		//Create game fields
		GameFieldModel model = new GameFieldModel(createModel(1));
		model.setPlane();
		model.setExitText();
		robot = Robot.getRobot();
		robot.setActiveField( fields[4][1] ) ;
		
		fields[4][1] = new GameField(model, 1, robot);

		
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
		// Draw all fields
		fields[4][1].draw(g);
		robot.draw();
		// For drawing air plane
		if (fields[4][1].getModel().getHasPlane() == true)
			fields[4][1].getModel().getPlane().draw(80, 80);

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

	// Creates a model based on a given key that is from 1 to 10
	private Cell[][] createModel(int key) {
		Cell[][] cells = new Cell[15][11];
		
		if (key == 1) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 11; j++) {
					cells[i][j] = new SimpleCell(i, j, true);
				}
			}
			for (int j = 0; j < 6; j++) {
				cells[6][j] = new LeftCell(6, j);
			}
			cells[6][6] = new DownLeftCell(6, 6);

			for (int i = 7; i < 15; i++) {
				for (int j = 0; j < 6; j++) {
					if (i == 13 && j == 2 || i == 13 && j == 3 || i==13 && j == 4){
						Random rand = new Random() ;
						cells[i][j] = new SimpleCell(i, j, new Box(Math.abs(rand.nextInt()%3) + 1));
					}
					else
						cells[i][j] = new SimpleCell(i, j);
				}
			}
			cells[7][6] = new DownCell(7, 6);
			cells[8][6] = new DownCell(8, 6);

			for (int i = 9; i < 15; i++)
				cells[i][6] = new SimpleCell(i, 6);

			for (int i = 6; i < 9; i++) {
				for (int j = 7; j < 11; j++) {
					cells[i][j] = new SimpleCell(i, j, true);
				}
			}

			for (int j = 7; j < 11; j++) {
				cells[9][j] = new LeftCell(9, j);
			}

			for (int i = 10; i < 15; i++) {
				for (int j = 7; j < 11; j++) {
					if (i == 13 && j == 8 || i == 13 && j == 9 ){
						Random rand = new Random() ;
						cells[i][j] = new SimpleCell(i, j, new Box(Math.abs(rand.nextInt()%3) + 1));
					}
					else
						cells[i][j] = new SimpleCell(i, j);
				}
			}
		}

		return cells;
	}	
	/**
	 * Gives active game field
	 * @return	Active field
	 */
	public GameField getActiveGameField(){
		return fields[4][1] ;
	}
}
