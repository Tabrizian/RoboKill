package game.inventory;

import game.Position;

public class ItemsDatabase {

	private Item[][] itemsTabular;
	private Item[] weaponItems;
	private static ItemsDatabase instance = null;

	private ItemsDatabase() {
		itemsTabular = new Item[7][4];
		weaponItems = new Item[4];
		instance = this;
	}

	public static ItemsDatabase getItemsDatabase() {
		if (instance == null)
			new ItemsDatabase();
		return instance;
	}

	public void addToTabular(int row, int col, Item item) {
		itemsTabular[row][col] = item;
	}

	public void addToWeapons(int place, Item item) {
		weaponItems[place] = item;
	}

	/**
	 * Draws all of the items and
	 */
	public void drawAll() {
		int x = -1, y = -1;

		for (int i = 0; i < 7 && x == -1 && y == -1; i++) {
			for (int j = 0; j < 4; j++) {
				if (itemsTabular[i][j].isLifted()) {
					x = i;
					y = j;
					break;
				}
			}
		}

		for (int i = 0; i < weaponItems.length; i++) {
			if (weaponItems[i].isLifted()) {
				x = i;
				break;
			}
		}
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 4; j++) {
				if (x == -1) {
					if (y == -1) {
						itemsTabular[i][j].draw();
					}
				} else {
					if (y == -1)
						itemsTabular[i][j].draw();
					else if (x != i || y != j)
						itemsTabular[i][j].draw();
				}
			}
		}

		for (int i = 0; i < weaponItems.length; i++) {
			if (x == -1) {
				if (y == -1) {
					weaponItems[i].draw();
				}
			} else {
				if (y == -1 && i != x) {
					weaponItems[i].draw();
				} else if (y != -1) {
					weaponItems[i].draw();
				}
			}

		}

		if (y == -1 && x != -1)
			weaponItems[x].draw();
		if (y != -1 && x != -1)
			itemsTabular[x][y].draw();
	}

	/**
	 * @param
	 * @return Null if the position is inside no items otherwise returns the
	 *         item which is pointed to.
	 */
	public Item thePointed(Position pos) {
		for (Item[] items : itemsTabular) {
			for (Item item : items) {
				if (item.isInside(pos) && !item.isLifted()) {
					return item;
				}
			}
		}
		for (Item item : weaponItems) {
			if (item.isInside(pos) && !item.isLifted()) {
				return item;
			}
		}
		return null;
	}

	public boolean isAnyOneLifted() {
		for (Item[] items : itemsTabular) {
			for (Item item : items) {
				if (item.isLifted()) {
					return true;
				}
			}
		}
		for (Item item : weaponItems) {
			if (item.isLifted()) {
				return true;
			}
		}
		return false;

	}
}
