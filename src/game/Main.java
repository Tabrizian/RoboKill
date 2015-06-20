package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {

	public static final String gameName = "Robo Kill!";
	public static final int pregame = 1;
	public static final int play = 0;

	public Main() {
		super(gameName);
		addState(new Game());
		addState(new PreGame());
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		getState(play).init(gc, this);
		getState(pregame).init(gc, this);
	}

	public static void main(String[] args) {
		
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Main());
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
