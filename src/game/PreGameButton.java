package game;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class PreGameButton {

	private static int population = 0;

	private Image img;
	private Image imgFocused;
	private String addressOfImg;
	private String addressOfImgFocused;
	/**
	 * It's text.
	 */
	private String text;
	/**
	 * If mouse is over it or not.
	 */
	private boolean focused = false;
	/**
	 * Position to draw image.
	 */
	private Position pos;
	/**
	 * Customized font for drawing string.
	 */
	private TrueTypeFont font;

	public PreGameButton(String text) {
		addressOfImg = "pics/buttons/image 462.png";
		addressOfImgFocused = "pics/buttons/image 597.png";
		this.text = text;
		pos = new Position(300, 220 + population * 60);
		population++;
	}

	public void init() {

		try {
			img = new Image(addressOfImg);
			imgFocused = new Image(addressOfImgFocused);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// load a custom java font
		Font awtFont = new Font("Verdana", Font.ITALIC, 20);
		font = new TrueTypeFont(awtFont, true);

	}

	public void draw(Graphics g) {

		if (!focused)
			img.draw(pos.getX(), pos.getY());
		else
			imgFocused.draw(pos.getX(), pos.getY());

		font.drawString(pos.getX() + 15, pos.getY() + 8, text, new Color(255,
				170, 0));
	}

	public void update(GameContainer gc, StateBasedGame sbg) {
		Input input = gc.getInput();
		float mX = input.getMouseX();
		float mY = input.getMouseY();

		if (mX > pos.getX() && mX < (pos.getX() + 150)
				&& mY < (pos.getY() + 30) && mY > pos.getY()) {
			focused = true;
			// Entering to game state.
			if (input.isMousePressed(0) && text.equals("START"))
				sbg.enterState(1);
		} else {
			focused = false;
		}

	}

}
