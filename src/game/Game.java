package game;

import game.objects.Robot;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.loading.DeferredResource;
import org.newdawn.slick.loading.LoadingList;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {

	/**
	 * Current working game field.
	 */

	private Label cash;
	private Label shield;
	private Map map;
	/**
	 * Player who controls robot
	 */
	private Player player;
	/**
	 * Utility buttons
	 */
	private UtilityButton mapButton;
	private UtilityButton menu;
	private UtilityButton inv;
	//private DeferredResource nextResource;
	/** True if we've loaded all the resources and started rendering */
	private boolean started;

	/**
	 * Creates new Game with sample game field.
	 */
	public Game() {

		map = Map.getMap();
		player = Player.getPlayer();

		mapButton = new UtilityButton("map");
		inv = new UtilityButton("inv");
		menu = new UtilityButton("menu");
		cash = new Label("cash");
		shield = new Label("shield");
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
	//	LoadingList.setDeferredLoading(true);
		map.init();
		
		mapButton.init();
		menu.init();
		inv.init();
		cash.init();
		shield.init();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {

			map.draw(g);
			mapButton.draw(g);

			menu.draw(g);
			cash.draw(g, Robot.getRobot().getHealth(), player.getCash());
			shield.draw(g, Robot.getRobot().getHealth(),
					player.getCash());
			inv.draw(g);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {

		map.update(gc);
		
		mapButton.update(gc, sbg);
		inv.update(gc, sbg);
		menu.update(gc, sbg);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
