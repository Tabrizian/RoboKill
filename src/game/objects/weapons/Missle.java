package game.objects.weapons;

import game.Position;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Missle {
	private Position pos;
	private Image img;
	/**
	 * Angle at which missle is shooted.
	 */
	private float angle;

	public Missle(float angle,Position pos) {
		this.angle = angle;
		this.pos = new Position(pos);
		init();
	}

	/**
	 * Initialize missle
	 */
	public void init() {
		try {
			img = new Image("src/game/images/fires/image 233.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw() {
		img.draw(pos.getX(), pos.getY());
	}

	/**
	 * Updates position of missle.
	 * @param gc
	 */
	public void update(GameContainer gc){
		pos.setX(pos.getX() + (float) Math.cos(angle));
		pos.setY(pos.getY() + (float) Math.sin(angle));
	}
	
	public Position getPos(){
		return pos;
	}

}
