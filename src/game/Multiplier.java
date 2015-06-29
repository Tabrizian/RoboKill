package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Multiplier extends BasicGameState {

	private PreGameButton searchAndJoin;
	private PreGameButton create;
	
	public Multiplier(String name) {
		PreGameButton.resetCounter();
		searchAndJoin = new PreGameButton("SEARCH");
		create = new PreGameButton("CREATE");
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		searchAndJoin.init();
		create.init();
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		searchAndJoin.draw(g);
		create.draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		searchAndJoin.update(gc, sbg);
		create.update(gc, sbg);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
