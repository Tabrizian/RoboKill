package game;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.GUIContext;

public class MyTextField extends org.newdawn.slick.gui.TextField {

	private static TrueTypeFont font = new TrueTypeFont(new java.awt.Font("Verdana", java.awt.Font.ITALIC, 20), true);

	public MyTextField(GUIContext container, int x, int y, int width, int height) {
		super(container, font, x, y, width, height);
		setText("Hello!!!!!!!!!!!!");
	}


}
