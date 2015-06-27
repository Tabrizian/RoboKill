package game;

import java.util.Random;

import game.cells.Cell;
import game.cells.DownCell;
import game.cells.DownLeftCell;
import game.cells.DownRightCell;
import game.cells.LeftCell;
import game.cells.RightCell;
import game.cells.SimpleCell;
import game.cells.UpCell;
import game.inventory.Inventory;
import game.objects.Barrel;
import game.objects.Box;
import game.objects.Robot;
import game.objects.Wall;
import game.objects.weapons.blasters.LightBlaster;
import game.objects.weapons.blasters.MediumBlaster;
import game.objects.weapons.shotguns.HeavyShotgun;
import game.objects.weapons.shotguns.LightShotgun;

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
		// Create game fields
		createGameFields();
		robot = Robot.getRobot();
		robot.setActiveField(fields[3][2]);

		robot.init();
		// Initialize fields
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				if (fields[i][j] != null)
					fields[i][j].init();

		HeavyShotgun heavyShotgun = new HeavyShotgun(0, "robot");
		MediumBlaster MediumBlaster = new MediumBlaster(3, "robot");
		LightBlaster lightBlaster = new LightBlaster(1, "robot");
		LightShotgun lightShotgun = new LightShotgun(2, "robot");

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
		// Draw active fields
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {
				if (fields[i][j] != null) {
					if (fields[i][j].getActivation()) {
						fields[i][j].draw(g);
						robot.draw();
						// For drawing air plane
						if (fields[i][j].getModel().getHasPlane() == true)
							fields[i][j].getModel().getPlane().draw(80, 80);

						if (robot.getHealth() == 0)
							robot.getText().drawCentered(400, 300);
					}
				}
			}

	}

	/**
	 * Update the robot and field that is activated in gc
	 * 
	 * @param gc
	 */
	public void update(GameContainer gc) {
		robot.update(gc);
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {
				if (fields[i][j] != null) {
					if (fields[i][j].getActivation())
						fields[i][j].update(gc);
				}
			}
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
					if (i == 13 && j == 2 || i == 13 && j == 3 || i == 13
							&& j == 4) {
						Random rand = new Random();
						cells[i][j] = new SimpleCell(i, j, new Box(
								Math.abs(rand.nextInt() % 3) + 1));
					} else
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
				if (j == 7 || j == 8)
					cells[9][j] = new LeftCell(9, j, new Barrel(2));
				else
					cells[9][j] = new LeftCell(9, j);
			}

			for (int i = 10; i < 15; i++) {
				for (int j = 7; j < 11; j++) {
					if (i == 13 && j == 8 || i == 13 && j == 9) {
						Random rand = new Random();
						cells[i][j] = new SimpleCell(i, j, new Box(
								Math.abs(rand.nextInt() % 3) + 1));
					} else
						cells[i][j] = new SimpleCell(i, j);
				}
			}
		} else if (key == 2) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 11; j++) {
					if (i == 1 && j == 1 || i == 1 && j == 2 || i == 2
							&& j == 1 || i == 2 && j == 2)
						cells[i][j] = new SimpleCell(i, j, new Box());
					else if (i == 1 && j == 6 || i == 2 && j == 6)
						cells[i][j] = new SimpleCell(i, j, new Barrel());
					else if ((i == 11 || i == 12)
							&& (j == 4 || j == 5 || j == 6))
						cells[i][j] = new SimpleCell(i, j, new Box(3));
					else
						cells[i][j] = new SimpleCell(i, j);
				}
			}
		} else if (key == 3) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 4; j++) {
					cells[i][j] = new SimpleCell(i, j, true);
				}
			}

			for (int i = 0; i < 15; i++)
				cells[i][4] = new UpCell(i, 4);

			for (int i = 0; i < 15; i++)
				cells[i][5] = new SimpleCell(i, 5);

			for (int i = 0; i < 6; i++)
				cells[i][6] = new DownCell(i, 6);

			for (int i = 6; i < 9; i++)
				cells[i][6] = new SimpleCell(i, 6);

			for (int i = 9; i < 15; i++)
				cells[i][6] = new DownCell(i, 6);

			for (int i = 7; i < 11; i++)
				cells[6][i] = new LeftCell(6, i);

			for (int i = 7; i < 11; i++)
				cells[7][i] = new SimpleCell(7, i);

			for (int i = 7; i < 11; i++)
				cells[8][i] = new RightCell(8, i);

			for (int i = 0; i < 6; i++)
				for (int j = 7; j < 11; j++)
					cells[i][j] = new SimpleCell(i, j, true);

			for (int i = 9; i < 15; i++)
				for (int j = 7; j < 11; j++)
					cells[i][j] = new SimpleCell(i, j, true);
		} else if (key == 4) {
			for (int i = 0; i < 12; i++)
				for (int j = 0; j < 8; j++) {
					if ((i == 8 || i == 9) && (j == 5 || j == 6))
						cells[i][j] = new SimpleCell(i, j, new Wall());
					else if (j == 2 && (i == 2 || i == 3 || i == 4 || i == 5))
						cells[i][j] = new SimpleCell(i, j, new Box((i % 3) + 1));
					else
						cells[i][j] = new SimpleCell(i, j);
				}

			for (int i = 0; i < 13; i++) {
				if (i == 12)
					cells[i][8] = new DownRightCell(i, 8 , new Barrel(1));
				else if( i== 11 || i == 10)
					cells[i][8] = new DownCell(i, 8 , new Barrel(1));
				else
					cells[i][8] = new DownCell(i, 8);
			}
			
			for( int i = 0 ; i < 8 ; i++ )
				cells[12][i] = new RightCell(12, i) ;
			
			for( int i = 0 ; i < 15 ; i++ )
				for( int j = 0 ; j < 11 ; j++ )
					if( cells[i][j] == null )
						cells[i][j] = new SimpleCell(i, j , true) ;
		} else if (key == 5) {
			for (int i = 0; i < 11; i++)
				cells[7][i] = new SimpleCell(7, i);
			for (int i = 0; i < 11; i++)
				cells[6][i] = new LeftCell(6, i);
			for (int i = 0; i < 11; i++)
				cells[8][i] = new RightCell(8, i);
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 11; j++)
					cells[i][j] = new SimpleCell(i, j, true);
			for (int i = 9; i < 15; i++)
				for (int j = 0; j < 11; j++)
					cells[i][j] = new SimpleCell(i, j, true);
		}
		return cells;
	}

	/**
	 * Gives active game field
	 * 
	 * @return Active field
	 */
	public GameField getActiveGameField() {
		return fields[4][1];
	}

	private void createGameFields() {
		// Makes some of the fields null
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 3; j++)
				fields[i][j] = null;
		fields[0][2] = null;
		fields[4][0] = null;
		fields[4][2] = null;
		for (int i = 2; i < 5; i++)
			for (int j = 3; j < 5; j++)
				fields[i][j] = null;
		// Creates game field 1
		GameFieldModel model1 = new GameFieldModel(createModel(1));
		model1.setPlane();
		model1.setExitText();
		int[] state1 = new int[4];
		state1[0] = 0;
		state1[1] = -1;
		state1[2] = -1;
		state1[3] = -1;
		fields[4][1] = new GameField(model1, 1, state1);
		fields[4][1].setActivation(false);
		// Creates game field 2
		GameFieldModel model2 = new GameFieldModel(createModel(2));
		int[] state2 = new int[4];
		state2[0] = -1;
		state2[1] = 0;
		state2[2] = -1;
		state2[3] = -1;
		fields[3][0] = new GameField(model2, 3, state2);
		fields[3][0].setActivation(false);
		// Creates game field 3
		GameFieldModel model3 = new GameFieldModel(createModel(3));
		int[] state3 = new int[4];
		state3[0] = -1;
		state3[1] = 0;
		state3[2] = 0;
		state3[3] = 0;
		fields[3][1] = new GameField(model3, 7, state3);
		fields[3][1].setActivation(false);
		// Creates game field 4
		GameFieldModel model4 = new GameFieldModel(createModel(4));
		int[] state4 = new int[4];
		state4[0] = 0;
		state4[1] = -1;
		state4[2] = -1;
		state4[3] = 0;
		fields[3][2] = new GameField(model4, 2, state4);
		fields[3][2].setActivation(true);
		// Creates game field 5
		GameFieldModel model5 = new GameFieldModel(createModel(5));
		int[] state5 = new int[4];
		state5[0] = 0;
		state5[1] = -1;
		state5[2] = 0;
		state5[3] = -1;
		fields[2][2] = new GameField(model5, 4, state5);
		fields[2][2].setActivation(true);
		// Creates game field 6
		GameFieldModel model6 = new GameFieldModel(createModel(1));
		int[] state6 = new int[4];
		state6[0] = -1;
		state6[1] = 0;
		state6[2] = 0;
		state6[3] = -1;
		fields[1][2] = new GameField(model6, 4, state6);
		fields[1][2].setActivation(false);
		// Creates game field 7
		GameFieldModel model7 = new GameFieldModel(createModel(1));
		int[] state7 = new int[4];
		state7[0] = 0;
		state7[1] = 0;
		state7[2] = -1;
		state7[3] = 0;
		fields[1][3] = new GameField(model7, 4, state7);
		fields[1][3].setActivation(false);
		// Creates game field 8
		GameFieldModel model8 = new GameFieldModel(createModel(1));
		int[] state8 = new int[4];
		state8[0] = 0;
		state8[1] = -1;
		state8[2] = -1;
		state8[3] = 0;
		fields[1][4] = new GameField(model8, 7, state8);
		fields[1][4].setActivation(false);
		// Creates game field 9
		GameFieldModel model9 = new GameFieldModel(createModel(1));
		int[] state9 = new int[4];
		state9[0] = -1;
		state9[1] = 0;
		state9[2] = 0;
		state9[3] = -1;
		fields[0][3] = new GameField(model9, 6, state9);
		fields[0][3].setActivation(false);
		// Creates game field 10
		GameFieldModel model10 = new GameFieldModel(createModel(1));
		int[] state10 = new int[4];
		state10[0] = -1;
		state10[1] = -1;
		state10[2] = 0;
		state10[3] = 0;
		fields[0][4] = new GameField(model10, 10, state10);
		fields[0][4].setActivation(false);
	}
}
