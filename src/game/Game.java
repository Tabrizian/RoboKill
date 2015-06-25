package game;

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
	private JLabel cash;
	private JLabel shield;
	private Map Map;
	/**
	 * Utility buttons
	 */
	private UtilityButton map;
	private UtilityButton menu;
	private UtilityButton inv;

	/**
	 * Creates new Game with sample gamefield.
	 */
	public Game() {

		Map = Map.getMap();

		map = new UtilityButton("map");
		inv = new UtilityButton("inv");
		menu = new UtilityButton("menu");
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {

		Map.init();
		map.init();
		menu.init();
		inv.init();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
		Map.draw(g);
		map.draw(g);
		inv.draw(g);
		menu.draw(g);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {
		Map.update(gc);
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
