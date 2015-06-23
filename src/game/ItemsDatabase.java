package game;

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

	public void drawAll() {
		int x = -1, y = -1;

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 4; j++) {
				if (y == -1)
					itemsTabular[i][j].draw();
				else if (x != i && y != j)
					itemsTabular[i][j].draw();
			}
		}

		for (int i = 0; i < weaponItems.length; i++) {

			if (y == -1 && x != i)
				weaponItems[i].draw();
			else if (y != -1)
				weaponItems[i].draw();

		}

		for (int i = 0; i < 7 && x == -1 && y == -1; i++) {
			for (int j = 0; j < 4; j++) {
				if (itemsTabular[i][j].isLifted()) {
					itemsTabular[i][j].draw();
					x = i;
					y = j;
					break;
				}
			}
		}

		for (int i = 0; i < weaponItems.length; i++) {
			if (weaponItems[i].isLifted()) {
				weaponItems[i].draw();
				x = i;
				break;
			}
		}
	}
}
