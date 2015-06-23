package game;

import game.objects.Inventory;
import game.objects.Robot;
import game.objects.weapons.Blasters.HeavyBlaster;
import game.objects.weapons.Blasters.LightBlaster;
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

	private UtilityButton map;
	private UtilityButton menu;
	private UtilityButton inv;

	/**
	 * Creates new Game with sample gamefield.
	 */
	public Game() {
		robot = new Robot();
		field = new GameField();
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
		LightShotgun lightShotgun = new LightShotgun(0);
		HeavyBlaster heavyBlaster = new HeavyBlaster(3) ;
		robot.addGun(lightShotgun, 0);
		// Adding light shotgun to inventory for test.
		Inventory.getInventory().add(lightShotgun, 0);
		Inventory.getInventory().add(heavyBlaster, 3);
		// robot.addGun(new LightBlaster(1) , 1 );
		 robot.addGun(heavyBlaster , 3 );
		//robot.addGun(new HeavyShotgun(3), 3);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {

		field.draw(g);
		robot.draw();
		map.draw(g);
		inv.draw(g);
		menu.draw(g);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {

		robot.update(gc);
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
