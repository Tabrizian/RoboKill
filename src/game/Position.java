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
	private float x;
	/**
	 * Y Position
	 */
	private float y;

	public Position(Position pos) {
		x = pos.getX();
		y = pos.getY();
	}

	public Position(float xPos, float yPos) {
		this.x = xPos;
		this.y = yPos;
	}

	/**
	 * Decrease X position if X be greater than zero
	 */
	public void decX() {
		if (x > 4)
			x -= 3;
	}

	/**
	 * Increase X position without condition
	 */
	public void incX() {
		x += 3;
	}

	/**
	 * Increase X position if X be lower than a limit
	 * 
	 * @param limit
	 */
	public void incX(int limit) {
		if (x < limit - 3)
			x += 3;
	}

	/**
	 * Decrease Y position if Y be greater than zero
	 */
	public void decY() {
		if (y > 3)
			y -= 3;
	}

	/**
	 * Increase Y position without condition
	 */
	public void incY() {
		y += 3;
	}

	/**
	 * Increase Y position if Y be lower than a limit
	 * 
	 * @param limit
	 */
	public void incY(int limit) {
		if (y < limit - 3)
			y += 3;
	}

	/**
	 * Getter of X
	 * 
	 * @return x
	 */
	public float getX() {
		return x;
	}

	/**
	 * Getter of Y
	 * 
	 * @return Y
	 */
	public float getY() {
		return y;
	}

	/**
	 * Setter of X
	 * 
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Setter of Y
	 * 
	 * @param y
	 */
	public void setY(float y) {
		this.y = y;
	}
}
