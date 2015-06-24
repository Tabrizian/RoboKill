package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {

	public static final String gameName = "Robo Kill!";
	public static final int pregame = 0;
	public static final int play = 1;

	public Main() {
		super(gameName);
		addState(new PreGame());
		addState(new Game());
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		String[] icons = {"pics/icon/icon16.png","pics/icon/icon32.png" ,  "pics/icon/icon24.png", };
		gc.setIcons(icons);
		getState(play).init(gc, this);
		getState(pregame).init(gc, this);
	}

	public static void main(String[] args) {

		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Main());
			appgc.setDisplayMode(800, 600, false);
			appgc.setShowFPS(false);
			//appgc.setIcon("pics/icon/icon2.ico");
			appgc.start();
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

