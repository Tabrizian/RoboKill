package game;

/**
 * This is position class that contain position of component in a frame
 * 
 * @author mahdi
 *
 */
public class Position {

	/**
	 * X Position
	 */
	private int x;
	/**
	 * Y Position
	 */
	private int y;

	public Position() {

	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Decrease X position if X be greater than zero
	 */
	public void decX() {
		if (x > 1)
			x--;
	}

	/**
	 * Increase X position without condition
	 */
	public void incX() {
		x++;
	}

	/**
	 * Increase X position if X be lower than a limit
	 * @param limit
	 */
	public void incX(int limit) {
		if (x < limit)
			x++;
	}
	
	/**
	 * Decrease Y position if Y be greater than zero
	 */
	public void decY() {
		if (y > 1)
			y--;
	}

	/**
	 * Increase Y position without condition
	 */
	public void incY() {
		y++;
	}

	/**
	 * Increase Y position if Y be lower than a limit
	 * @param limit
	 */
	public void incY(int limit) {
		if (y < limit)
			y++;
	}
}
