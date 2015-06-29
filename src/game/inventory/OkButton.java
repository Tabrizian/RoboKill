package game.inventory;

import game.Position;
import game.UtilityButton;

import java.awt.Font;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class OkButton {

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

	//For animation
	private boolean isPlayBack = false ;
	private Image[] frames1 ;
	private Animation playBack ;
	
	public OkButton(String text,Position pos) {
		addressOfImg = "pics/buttons/image 547.png";
		addressOfImgFocused = "pics/buttons/image 5471.png";
		this.text = text;
		this.pos = pos;
		population++;
		frames1 = new Image[46] ;
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
		
		for (int i = 1; i <= 46; i++) {
			String s = Integer.toString(i);
			try {
				frames1[46 - i] = new Image("pics/inventory/" + s + ".png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		playBack = new Animation(frames1, 5);
		playBack.setLooping(false);

	}

	public void draw(Graphics g) {

		if (!focused)
			img.draw(pos.getX(), pos.getY());
		else
			imgFocused.draw(pos.getX(), pos.getY());

		font.drawString(pos.getX() + 65, pos.getY() + 8, text, new Color(0,
				253, 253));
	}

	public void update(GameContainer gc) {
		Input input = gc.getInput();
		float mX = input.getMouseX();
		float mY = input.getMouseY();

		if (mX > pos.getX() && mX < (pos.getX() + 161)
				&& mY < (pos.getY() + 41) && mY > pos.getY()) {
			focused = true;
			// Entering to game state.
			if (input.isMousePressed(0)){
				//isPlayBack = true ;
				if( UtilityButton.getInventoryState()){
					UtilityButton.setShowMap(true);
					UtilityButton.setInventoryState(true);
				}
				
				
			}
		} else {
			focused = false;
		}

	}

}
