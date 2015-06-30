package game.inventory;

import game.Player;
import game.Position;
import game.objects.weapons.Weapon;

public class ItemsDatabase {

	private Item[][] itemsTabular;
	private Item[] weaponItems;
	private Item[] upgradeItems;
	private Item[][] itemsTabularShop;
	private static ItemsDatabase instance = null;

	private ItemsDatabase() {
		itemsTabular = new Item[7][4];
		itemsTabularShop = new Item[7][4];
		weaponItems = new Item[4];
		upgradeItems = new Item[4];
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

	public void addToUpgrades(int place, Item item) {
		upgradeItems[place] = item;
	}

	public void addToShop(int row, int col, Item item) {
		itemsTabularShop[row][col] = item;
	}

	/**
	 * Draws all of the items and
	 */
	public void drawAll() {
		int x = -1, y = -1;
		int x1 = -1;
		int x2 = -1, y2 = -1;

		for (int i = 0; i < 7 && x == -1 && y == -1; i++) {
			for (int j = 0; j < 4; j++) {
				if (itemsTabular[i][j].isLifted()) {
					x = i;
					y = j;
					break;
				}
			}
		}

		for (int i = 0; i < 7 && x2 == -1 && y2 == -1; i++) {
			for (int j = 0; j < 4; j++) {
				if (itemsTabularShop[i][j].isLifted()) {
					x2 = i;
					y2 = j;
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

		for (int i = 0; i < upgradeItems.length; i++) {
			if (upgradeItems[i].isLifted()) {
				x1 = i;
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

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 4; j++) {

				if (x2 != i || y2 != j)
					itemsTabularShop[i][j].draw();

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

		for (int i = 0; i < upgradeItems.length; i++) {
			if (x1 != i)
				upgradeItems[i].draw();
		}

		if (y == -1 && x != -1)
			weaponItems[x].draw();
		if (y != -1 && x != -1)
			itemsTabular[x][y].draw();
		if (x1 != -1)
			upgradeItems[x1].draw();
		if (x2 != -1 && y2 != -1) {
			itemsTabularShop[x2][y2].draw();
		}
	}

	public void drawForInventor(){
		int x = -1, y = -1;
		int x1 = -1;
		int x2 = -1, y2 = -1;

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

		for (int i = 0; i < upgradeItems.length; i++) {
			if (upgradeItems[i].isLifted()) {
				x1 = i;
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

		for (int i = 0; i < upgradeItems.length; i++) {
			if (x1 != i)
				upgradeItems[i].draw();
		}

		if (y == -1 && x != -1)
			weaponItems[x].draw();
		if (y != -1 && x != -1)
			itemsTabular[x][y].draw();
		if (x1 != -1)
			upgradeItems[x1].draw();
		
		
	}
	/**
	 * @param
	 * @return Null if the position is inside no items otherwise returns the
	 *         item which is pointed to.
	 */
	public Item thePointed(Position pos) {
		for (Item[] items : itemsTabular) {
			for (Item item : items) {
				if (item.isInside(pos) && !item.isLifted()
						) {
					return item;
				}
			}
		}
		for (Item item : weaponItems) {
			if (item.isInside(pos) && !item.isLifted()
					) {
				return item;
			}
		}
		for (Item item : upgradeItems) {
			if (item.isInside(pos) && !item.isLifted()
					) {
				return item;
			}
		}
		for (Item[] items : itemsTabularShop) {
			for (Item item : items) {
				if (item.isInside(pos) && !item.isLifted()
						) {
					if (item.getAddOne() instanceof Weapon) {
						Weapon weapon = (Weapon) item.getAddOne();
						if (Player.getPlayer().getCash() > weapon.getPrice()){
							Player.getPlayer().setCash(Player.getPlayer().getCash() - weapon.getPrice());
							return item;
						}
					}
				}
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
		for (Item item : upgradeItems) {
			if (item.isLifted())
				return true;
		}
		
		for (Item[] items : itemsTabularShop) {
			for (Item item : items) {
				if (item.isLifted()) {
					return true;
				}
			}
		}
		return false;

	}

	public Item[] getWeapons() {
		return weaponItems;
	}

	public Item[][] getItemsTabular() {
		return itemsTabular;
	}

	public Item[] getUpgrades() {
		return upgradeItems;
	}

}
