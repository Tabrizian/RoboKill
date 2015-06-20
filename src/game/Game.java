package javagame;

import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

	public static final String gameName = "Robo Kill";
	public static final int gameField = 0;
	public static final int play = 1;

	public Game() {
		super(gameName);
		addState(new GameField(gameField));
		addState(new Play(play));
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		getState(gameField).init(gc, this);
		getState(play).init(gc, this);
	}

	public static void main(String[] args) {
		
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game());
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
