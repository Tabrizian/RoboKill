package game;

import game.cells.Cell;

public class GameFieldModel {

	private Cell[][] cells;

	public GameFieldModel(Cell[][] cells) {
		this.cells = cells;
	}

	public void setCell(int x, int y, Cell cell) {
		cell.setPos(new Position(x, y));
		cells[x][y] = cell;
	}

	public Cell getCell(int x, int y) {
		return cells[x][y];
	}
	
	public void drawAll(){
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 11; j++) {
				cells[i][j].draw();
			}
		}
	}

}
