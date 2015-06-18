package game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameField extends JPanel {

	private Cell[][] cells;
	private boolean isCleaned;
	private boolean isActivate;

	public GameField() {
		super();
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = null;
		try {
			img = ImageIO.read(new File("src/game/images/fields/image 187.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, null);

	}

}
