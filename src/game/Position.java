package game ;
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
		if (x > 4)
			x -= 5;
	}

	/**
	 * Increase X position without condition
	 */
	public void incX() {
		x += 5;
	}

	/**
	 * Increase X position if X be lower than a limit
	 * 
	 * @param limit
	 */
	public void incX(int limit) {
		if (x < limit - 3)
			x += 5;
	}

	/**
	 * Decrease Y position if Y be greater than zero
	 */
	public void decY() {
		if (y > 3)
			y -= 5;
	}

	/**
	 * Increase Y position without condition
	 */
	public void incY() {
		y += 5;
	}

	/**
	 * Increase Y position if Y be lower than a limit
	 * 
	 * @param limit
	 */
	public void incY(int limit) {
		if (y < limit - 3)
			y += 5;
	}

	/**
	 * Getter of X
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter of Y
	 * 
	 * @return Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter of X
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Setter of Y
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
}
