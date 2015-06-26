package game;

import game.cells.Cell;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameFieldModel {

	private Cell[][] cells;

	private boolean hasPlane = false;
	private Image plane;

	private boolean hasExitText = false;
	private Image exitText;

	/**
	 * @param cells
	 *            - a 11X15 two dimensional array of cells.
	 */
	public GameFieldModel(Cell[][] cells) {
		this.cells = cells;
	}

	/**
	 * Set cell at position x and y.
	 * 
	 * @param x
	 *            - the x position of the cell.
	 * @param y
	 *            - the y position of the cell.
	 * @param cell
	 *            - the cell which must be put at the position.
	 */
	public void setCell(int x, int y, Cell cell) {
		cell.setPos(new Position(x, y));
		cells[x][y] = cell;
	}

	/**
	 * @param x
	 * @param y
	 * @return The cell at that position.
	 */
	public Cell getCell(int x, int y) {
		return cells[x][y];
	}

	/**
	 * Draws all of the cells to the screen.
	 */
	public void drawAll() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 11; j++) {
				cells[i][j].draw();
			}
		}
	}

	/**
	 * Initializes all of the cells.
	 */
	public void initAll() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 11; j++) {
				cells[i][j].init();
			}
		}
		try {
			plane = new Image("pics/plane/image 335.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			exitText = new Image("pics/fields/image 122.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * If call this method set a plane for this game field model
	 */
	public void setPlane() {
		hasPlane = true;
	}
	/**
	 * Getter for hasPlane
	 * @return
	 */
	public boolean getHasPlane() {
		return hasPlane;
	}
	/**
	 * Getter for image of plane
	 * @return
	 */
	public Image getPlane() {
		return plane;
	}
	/**
	 * If call this method set a exit text for the model
	 */
	public void setExitText() {
		hasExitText = true;
	}
	/**
	 * Getter for hasExitText
	 * @return
	 */
	public boolean getHasExitText() {
		return hasExitText;
	}
	/**
	 * Getter for image of exitText
	 * @return
	 */
	public Image getExitText() {
		return exitText;
	}
	/**
	 * Returns a cell that exists in position (x,y)
	 * @param x
	 * @param y
	 * @return	A cell in position (x,y)
	 */
	public Cell getCellWithPos(float x, float y) {
		x -= 35;
		x /= 52;
		y -= 38;
		y /= 52;
		x += 1;
		y += 1;
		try{
			return cells[(int) x][(int) y];
		}catch( Exception e ){
			return cells[0][0] ;
		}

	}
}
