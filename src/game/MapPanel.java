package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MapPanel {

	private String simpleTile;
	private String backPanel;
	private String currentTile;
	private String visitedTile;
	private Image backPanelImage;
	private Image simpleTileImage;
	private Image currentTileImage;
	private Image visitedTileImage;
	private Position pos;
	private Position pos2;
	private static MapPanel instance = null;

	private MapPanel() {
		backPanel = "pics/inventory/inventory.png";
		simpleTile = "pics/map/image 287.png";
		currentTile = "pics/map/image 722.png";
		visitedTile = "pics/map/image 442.png";
		pos = new Position(50, 50);
		pos2 = new Position(250 + pos.getX(), 100 + pos.getY());
		instance = this;
	}

	public static MapPanel getMapPanel() {
		if (instance == null)
			new MapPanel();
		return instance;
	}

	public void init() {
		try {
			backPanelImage = new Image(backPanel);
			simpleTileImage = new Image(simpleTile);
			currentTileImage = new Image(currentTile);
			visitedTileImage = new Image(visitedTile);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw() {
		backPanelImage.draw(pos.getX(), pos.getY());
		GameField[][] fields = Map.getMap().getFields();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (fields[i][j] != null) {
					Position cal = calcPos(j,i);
					if (Map.getMap().getActiveGameField() == fields[i][j]) {
						currentTileImage.draw(cal.getX(), cal.getY());
					} else if (!fields[i][j].getIsCleaned()) {
						simpleTileImage.draw(cal.getX(), cal.getY());
					} else {
						visitedTileImage.draw(cal.getX(), cal.getY());
					}
				}
			}
		}
	}

	public void update(GameContainer gc) {
		GameField[][] fields = Map.getMap().getFields();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (fields[i][j] != null) {
					fields[i][j].updateCleanStatus();
				}
			}
		}
	}

	private Position calcPos(int x, int y) {
		return new Position(pos.getX() + pos2.getX() + x * (37 + 3) + 5,
				pos.getY() + pos2.getY() + y * (27 + 3));
	}

}
