package game;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class PreGameButton {

	private static int population = 0;

	private Image img;
	private Image imgFocused;
	private String addressOfImg;
	private String addressOfImgFocused;
	private String text;
	private Image current;
	private boolean focused = false;
	private Position pos;
	private TrueTypeFont font;
	private TrueTypeFont font2;

	public PreGameButton(String text) {
		addressOfImg = "pics/buttons/image 462.png";
		addressOfImgFocused = "pics/buttons/image 850.png";
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
		// load a default java font
		Font awtFont = new Font("Times New Roman", Font.ITALIC, 20);
		font = new TrueTypeFont(awtFont, true);

	}

	public void draw(Graphics g) {
		if (!focused)
			img.draw(pos.getX(), pos.getY());
		else
			imgFocused.draw(pos.getX(), pos.getY());

		g.setColor(Color.yellow);
		g.setFont(font);
		g.drawString(text, pos.getX() + 10, pos.getY() + 8);

	}

	public void update(GameContainer gc) {
		Input input = gc.getInput();
		float mX = input.getMouseX();
		float mY = input.getMouseY();

	}

}
