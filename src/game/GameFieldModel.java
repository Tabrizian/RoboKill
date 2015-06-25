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

	public void setPlane() {
		hasPlane = true;
	}

	public boolean getHasPlane() {
		return hasPlane;
	}

	public Image getPlane() {
		return plane;
	}

	public void setExitText() {
		hasExitText = true;
	}

	public boolean getHasExitText() {
		return hasExitText;
	}

	public Image getExitText() {
		return exitText;
	}

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
