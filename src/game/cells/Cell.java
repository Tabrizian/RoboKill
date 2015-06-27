package game.cells;

import game.Position;
import game.objects.Barrel;
import game.objects.Box;
import game.objects.Thing;
import game.objects.Wall;
import game.objects.weapons.MissilesDatabase;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Cell {

	protected Thing thing;
	protected Position pos;
	protected boolean isExploded;
	protected boolean isBlocked;
	protected boolean isNoun;
	protected Image image;

	public Cell(int row, int column, Thing thing) {
		isExploded = false;
		isNoun = false;
		isBlocked = true;
		pos = new Position(calPos(row, column));
		if (thing instanceof Box) {
			this.thing = new Box();
			this.thing = thing;
		} else if (thing instanceof Wall) {
			this.thing = new Wall();
			this.thing = thing;
		} else if (thing instanceof Barrel) {
			this.thing = new Barrel();
			this.thing = thing;
		}

		init();
	}

	public Cell(int row, int column) {
		isExploded = false;
		isNoun = false;
		isBlocked = false;
		pos = new Position(calPos(row, column));
	}

	public Cell(int row, int column, boolean isNoun) {
		isExploded = false;
		isBlocked = false;
		this.isNoun = isNoun;
		pos = new Position(calPos(row, column));
	}

	/**
	 * Getter for position of the cell on screen
	 * 
	 * @return pos
	 */
	public Position getPos() {
		return pos;
	}

	/**
	 * Setter for position of the cell on screen
	 * 
	 * @param pos
	 */
	public void setPos(Position pos) {
		this.pos = pos;
	}

	/**
	 * Add a thing to cell
	 * 
	 * @param thing
	 */
	public void setThing(Thing thing) {
		if (thing instanceof Box) {
			this.thing = new Box();
			this.thing = thing;
			isNoun = false;
			isBlocked = true;
		} else if (thing instanceof Wall) {
			this.thing = new Wall();
			this.thing = thing;
			isNoun = false;
			isBlocked = true;
		} else if (thing instanceof Wall) {
			this.thing = new Barrel();
			this.thing = thing;
			isNoun = false;
			isBlocked = true;
		}
	}

	/**
	 * Draw the cell behind its thing if exists
	 */
	public void draw(Graphics g) {
		if (isNoun == false)
			image.drawCentered(pos.getX(), pos.getY());
		if (thing != null) {
			thing.draw(pos.getX(), pos.getY());
		}

	}

	public void update() {
		if (thing != null) {
			MissilesDatabase.getMissilesDatabase().explodeForCells(pos, 25, 25);
			if (MissilesDatabase.getMissilesDatabase()
					.isEnemyMissileInsideArea(
							new Position(pos.getX() - 20, pos.getY() - 20), 45,
							45)) {
				if (thing.getHealth() > 0)
					thing.decHealth();
			}
			if (MissilesDatabase.getMissilesDatabase()
					.isRobotMissileInsideArea(
							new Position(pos.getX() - 20, pos.getY() - 20), 45,
							45)) {
				if (thing.getHealth() > 0)
					thing.decHealth();
			}
			if (thing.getHealth() == 0){
				isBlocked = false ;
				thing = null;
			}
		}
	}

	/**
	 * Loads images
	 */
	public abstract void init();

	/**
	 * Returns position of a certain cell
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	private Position calPos(int row, int column) {
		int xPos = row * 52 + 35;
		int yPos = column * 52 + 38;

		Position pos = new Position(xPos, yPos);

		return pos;
	}

	/**
	 * Getter for isBlocked
	 * 
	 * @return
	 */
	public boolean getIsBlocked() {
		return isBlocked;
	}

	/**
	 * Getter for isNoun
	 * 
	 * @return
	 */
	public boolean getIsNoun() {
		return isNoun;
	}
}
