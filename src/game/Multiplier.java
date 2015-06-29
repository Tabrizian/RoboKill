package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Multiplier extends BasicGameState {

	private PreGameButton searchAndJoin;
	private PreGameButton create;
	private String imageAddress;
	private Image image;
	
	public Multiplier(String name) {
		PreGameButton.resetCounter();
		searchAndJoin = new PreGameButton("SEARCH");
		create = new PreGameButton("CREATE");
		imageAddress = "pics/backgrounds/image 700.jpg";
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		image = new Image(imageAddress);
		searchAndJoin.init();
		create.init();
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		image.draw(0, 0);
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
