package game;

import game.cells.Cell;
import game.inventory.Inventory;
import game.objects.Robot;
import game.objects.enemies.Enemy;
import game.objects.enemies.Zombie;
import game.objects.weapons.Blasters.LightBlaster;
import game.objects.weapons.Blasters.MediumBlaster;
import game.objects.weapons.Shotguns.HeavyShotgun;
import game.objects.weapons.Shotguns.LightShotgun;

import javax.swing.JLabel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {

	/**
	 * Current working gamefield.
	 */
	private GameField field;
	private Robot robot;
	private JLabel cash;
	private JLabel shield;
	private Enemy enemy ;

	private UtilityButton map;
	private UtilityButton menu;
	private UtilityButton inv;

	/**
	 * Creates new Game with sample gamefield.
	 */
	public Game() {
		robot = new Robot();
		enemy = new Zombie(robot.getPos() , new Position(300, 300)) ;
		Cell[][] cells = new Cell[15][11];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 11; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
		GameFieldModel model = new GameFieldModel(cells);
		field = new GameField(model);
		map = new UtilityButton("map");
		inv = new UtilityButton("inv");
		menu = new UtilityButton("menu");
		
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// Initializing field.
		field.init();
		// Initializing buttons.
		map.init();
		menu.init();
		inv.init();
		robot.init();
		((Zombie) enemy).init() ;
		HeavyShotgun heavyShotgun = new HeavyShotgun(0);
		MediumBlaster MediumBlaster = new MediumBlaster(3);
		LightBlaster lightBlaster = new LightBlaster(1) ;
		LightShotgun lightShotgun = new LightShotgun(2) ;
		
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

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {

		field.draw(g);
		robot.draw();
		((Zombie) enemy).draw() ;
		map.draw(g);
		inv.draw(g);
		menu.draw(g);
		

	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {

		robot.update(gc);
		((Zombie) enemy).update(gc) ;
		((Zombie) enemy).setRobotPos(robot.getPos());
		field.update(gc);
		map.update(gc);
		inv.update(gc);
		menu.update(gc);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
