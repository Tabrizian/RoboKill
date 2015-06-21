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
	 * Initialize missile
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
	 * Updates position of missile.
	 * @param gc
	 */
	public void update(GameContainer gc){
		pos.setX(pos.getX() + (float) Math.sin(-Math.toRadians(angle)));
		pos.setY(pos.getY() + (float) Math.cos(-Math.toRadians(angle)));
	}
	
	public Position getPos(){
		return pos;
	}

}
