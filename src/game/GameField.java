package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameField extends JPanel {

	private Cell[][] cells;
	private boolean isCleaned;
	private boolean isActivate;

	// for double buffering
	private BufferedImage bufferedScreen;
	private Graphics2D bufferedGraphics;

	// Screen size
	private int width = (int) getToolkit().getScreenSize().getWidth();
	private int height = (int) getToolkit().getScreenSize().getHeight();

	public GameField() {
		super();

		Timer timer = new Timer(15, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();

		setSize(width * 59 / 100, height * 78 / 100);

		// Create the off screen buffer for offline drawing;
		bufferedScreen = new BufferedImage(this.getWidth(), this.getHeight(),
				BufferedImage.TYPE_4BYTE_ABGR_PRE);
		// Get the graphics of the off screen buffer;
		bufferedGraphics = (Graphics2D) bufferedScreen.createGraphics();

		setLayout(null);

	}

	@Override
	protected void paintComponent(Graphics g) {

		render(bufferedGraphics);

		g.drawImage(bufferedScreen, 0, 0, this);

	}

	private void render(Graphics2D g2d) {
		super.paintComponent(g2d);

		BufferedImage img = null;
		try {
			img = ImageIO
					.read(new File("src/game/images/fields/image 187.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);

	}

	public void update(Graphics g) {
		paintComponent(g);
	}
}
