package game;

import game.objects.Robot;
import game.objects.weapons.Blasters.LightBlaster;

import javax.swing.JButton;
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
	private JButton map;
	private JButton inv;
	private JButton menu;
	private JLabel cash;
	private JLabel shield;

	/**
	 * Creates new Game with sample gamefield.
	 */
	public Game() {
		robot = new Robot();
		field = new GameField();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		field.init();
		robot.init();
		robot.addGun(new LightBlaster() , 0 );
		robot.addGun(new LightBlaster() , 3 );
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {

		field.draw(g);
		robot.draw();

	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {

		robot.update(gc);
		field.update(gc);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
