package game;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PreGame extends BasicGameState {

	private JPanel menu;
	private JPanel profile;
	private Image backgroundImage;
	private String backgroundImageAddress;
	private PreGameButton start;
	private PreGameButton options;
	private PreGameButton credits;
	
	public PreGame() {
		backgroundImageAddress = "pics/backgrounds/image 700.jpg";
		start = new PreGameButton("START");
		options = new PreGameButton("OPTIONS");
		credits = new PreGameButton("CREDITS");
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		try {
			backgroundImage = new Image(backgroundImageAddress);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		start.init();
		options.init();
		credits.init();

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		backgroundImage.draw(0, 0);
		start.draw(g);
		options.draw(g);
		credits.draw(g);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}
