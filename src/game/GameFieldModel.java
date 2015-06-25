package game;

import game.cells.Cell;


public class GameFieldModel {

	private Cell[][] cells;

	/**
	 * @param cells - a 11X15 two dimensional array of cells.
	 */
	public GameFieldModel(Cell[][] cells) {
		this.cells = cells;
	}

	/**
	 * Set cell at position x and y.
	 * @param x - the x position of the cell.
	 * @param y - the y position of the cell.
	 * @param cell - the cell which must be put at the position.
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
	public void drawAll(){
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 11; j++) {
				cells[i][j].draw();
			}
		}
	}
	
	/**
	 * Initializes all of the cells.
	 */
	public void initAll(){
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 11; j++) {
				cells[i][j].init();
			}
		}
	}

}
