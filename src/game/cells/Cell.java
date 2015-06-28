package game.cells;

import game.Position;
import game.objects.Barrel;
import game.objects.Box;
import game.objects.Thing;
import game.objects.Wall;
import game.objects.prizes.Money;
import game.objects.prizes.Plunder;
import game.objects.prizes.Shield;
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
	protected Plunder plunder;
	protected boolean isPlunderShown = false ;

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

	public Cell(int row, int column, Thing thing, Plunder plunder) {
		isExploded = false;
		isNoun = false;
		isBlocked = true;
		if (plunder instanceof Money)
			this.plunder = new Money();
		else if (plunder instanceof Shield)
			this.plunder = new Shield();
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
			image.draw(pos.getX(), pos.getY());
		if (thing != null) {
			thing.draw(pos.getX(), pos.getY());
		}

	}

	public void update() {
		if (thing != null) {
			int healthReduction = MissilesDatabase.getMissilesDatabase().explodeForCells(
					new Position(pos.getX(), pos.getY()), 52, 52);
			if(healthReduction > thing.getHealth())
				thing.setHealth(0);
			else
				thing.setHealth(thing.getHealth() - healthReduction);
			if (thing.getHealth() == 0) {
				isBlocked = false;
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
		int xPos = row * 52 + 5;
		int yPos = column * 52 + 11;

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
	/**
	 * Getter for plunder
	 */
	public Plunder getPlunder(){
		return plunder ;
	}
	public Thing getThing(){
		return thing ;
	}
	public void setIsPlunderShown( boolean x ){
		isPlunderShown = x ;
	}
	public boolean getIsPlunderShown(){
		return isPlunderShown ;
	}
}
