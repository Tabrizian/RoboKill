package game;

import javax.swing.JPanel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PreGame extends BasicGameState {

	
	private JPanel profile;
	private Image backgroundImage;
	private String backgroundImageAddress;
	private String loadingImageAddress;
	private PreGameButton start;
	private PreGameButton options;
	private PreGameButton credits;
	private boolean imageLoaded = false;
	private Thread thread;
	private Image backgroundLoadingImage;

	public PreGame() {
		backgroundImageAddress = "pics/backgrounds/image 700.jpg";
		loadingImageAddress = "pics/backgrounds/image 3.jpg";
		start = new PreGameButton("START");
		options = new PreGameButton("OPTIONS");
		credits = new PreGameButton("CREDITS");

	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		backgroundLoadingImage = new Image(loadingImageAddress);

		try {
			backgroundImage = new Image(backgroundImageAddress);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		start.init();
		options.init();
		credits.init();
		imageLoaded = true;
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		if (imageLoaded) {
			backgroundImage.draw(0, 0);
			start.draw(g);
			options.draw(g);
			credits.draw(g);
		} else {
			backgroundLoadingImage.draw(0, 0);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		start.update(gc, sbg);
		options.update(gc, sbg);
		credits.update(gc, sbg);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
}
