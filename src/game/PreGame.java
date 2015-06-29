package game;

import java.io.IOException;

import javax.swing.JPanel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.loading.DeferredResource;
import org.newdawn.slick.loading.LoadingList;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PreGame extends BasicGameState {

	private JPanel profile;
	private Image backgroundImage;
	private Music music;
	private String backgroundImageAddress;
	private String loadingImageAddress;
	private String musicAddress;
	private PreGameButton start;
	private PreGameButton options;
	private PreGameButton credits;
	private PreGameButton multiplier;
	private String loadingBarAddress;
	private Image loadingBar;
	private DeferredResource nextResource;
	private boolean getNameState = false;
	private MyTextField textField;
	/** True if we've loaded all the resources and started rendereing */
	private boolean started;

	private Image backgroundLoadingImage;

	public PreGame() {
		backgroundImageAddress = "pics/backgrounds/image 700.jpg";
		loadingImageAddress = "pics/backgrounds/image 3.jpg";
		loadingBarAddress = "pics/loading/image 1.png";
		musicAddress = "musics/pregame.ogg";
		start = new PreGameButton("START");
		options = new PreGameButton("OPTIONS");
		credits = new PreGameButton("CREDITS");
		multiplier = new PreGameButton("MULTI");

	}

	@Override
	public void init(GameContainer gc, StateBasedGame arg1) {
		textField = new MyTextField(gc, 100, 50, 200, 20);
		LoadingList.setDeferredLoading(true);

		try {
			backgroundLoadingImage = new Image(loadingImageAddress);
			loadingBar = new Image(loadingBarAddress);
			music = new Music(musicAddress, true);
			backgroundImage = new Image(backgroundImageAddress);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		start.init();
		options.init();
		credits.init();
		multiplier.init();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
		textField.render(gc, g);
		if (started) {
			backgroundImage.draw(0, 0);

			start.draw(g);
			options.draw(g);
			credits.draw(g);
			multiplier.draw(g);

		} else {

			int total = LoadingList.get().getTotalResources();
			int loaded = LoadingList.get().getTotalResources()
					- LoadingList.get().getRemainingResources();

			backgroundLoadingImage.draw(0, 0);
			loadingBar.draw(70, 528, 658 * (((float) loaded) / total), 12);

		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		start.update(gc, sbg);
		options.update(gc, sbg);
		credits.update(gc, sbg);
		multiplier.update(gc, sbg);
		if (nextResource != null) {
			try {
				nextResource.load();
			} catch (IOException e) {
				throw new SlickException("Failed to load: "
						+ nextResource.getDescription(), e);
			}

			nextResource = null;
		}

		if (LoadingList.get().getRemainingResources() > 0) {
			nextResource = LoadingList.get().getNext();
		} else {
			if (!started) {
				started = true;
				music.play();
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void stopMusic() {
		music.stop();
	}

	public void setGetNameState(boolean state) {
		getNameState = state;
	}
}
