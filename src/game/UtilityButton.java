package game;

import game.inventory.Inventory;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class UtilityButton {

	private Image img;
	private static int population = 0;
	private String imgAddress;
	private String name;
	private Position pos;
	private boolean focused = false;
	private Inventory inventory;
	private static boolean showInventory = false;
	private static boolean state = false ;
	
	private Image[] frames;
	private Animation play;
	private Image[] frames1 ;
	private Animation playBack ;

	private boolean isAnimationDrawe = false;
	private boolean imageDraw = false ;
	private boolean isPlayBack ;
	
	public UtilityButton(String name) {
		this.name = name;
		pos = new Position(665 + population * 45, 590);

		imgAddress = "pics/buttons/" + name + ".png";
		population++;

		frames = new Image[46];
		frames1 = new Image[46] ;
		
		inventory = Inventory.getInventory();
	}

	/**
	 * Loads image
	 */
	public void init() {
		inventory.init();
		try {
			img = new Image(imgAddress);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 1; i <= 46; i++) {
			String s = Integer.toString(i);
			try {
				frames[i - 1] = new Image("pics/inventory/" + s + ".png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 1; i <= 46; i++) {
			String s = Integer.toString(i);
			try {
				frames1[46 - i] = new Image("pics/inventory/" + s + ".png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		play = new Animation(frames, 5);
		play.setLooping(false);
		
		playBack = new Animation(frames1, 5);
		playBack.setLooping(false);
	}

	/**
	 * Draws button and draws focused button with Graphics g
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		img.draw(pos.getX(), pos.getY());
		if (focused)
			g.drawRect(pos.getX(), pos.getY(), 45, 13);
	
		
		if (showInventory) {
			
			if (isAnimationDrawe) {
				play.setLooping(false);
				play.draw(50 , 50);
				play.start();

				if (play.getFrame() == 45) {
					play = null;
					play = new Animation(frames, 5);
					isAnimationDrawe = false;
					imageDraw = true ;
					inventory.draw(g);
				}
			}else if( imageDraw == true )
				inventory.draw(g);
			
		}
		else{
			if( isPlayBack ){
				playBack.setLooping(false);
				playBack.draw(50 , 50);
				playBack.start();

				if (playBack.getFrame() == 45) {
					playBack = null;
					playBack = new Animation(frames1, 5);
					isPlayBack = false;
				}
			}
		}
		
		

	}

	/**
	 * Listener for the button
	 * 
	 * @param gc
	 * @param sbg
	 */
	public void update(GameContainer gc, StateBasedGame sbg) {
		Input input = gc.getInput();

		float mX = input.getMouseX();
		float mY = input.getMouseY();
		inventory.update(gc);

		if ((mX > pos.getX() && mX < (pos.getX() + 45) && mY < (pos.getY() + 13)
				&& mY > pos.getY()) || state) {
			focused = true;
			if (input.isMousePressed(0) || state) {
				switch (name) {
				case "inv":
					showInventory = !showInventory;
					if( !showInventory ){
						if( imageDraw == true )
							isPlayBack = true ;
						imageDraw = false ;
					}
					isAnimationDrawe = true ;
					state = false ;
					break;
				case "menu":
					sbg.enterState(0);
					break;
				}
			}
		} else
			focused = false;

	}

	public static void setInventoryState(boolean show ) {
		state = show;
		
	}
	
	public static boolean getInventoryState(){
		return showInventory ;
	}
}
