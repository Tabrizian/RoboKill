package game.objects;

import game.Position;
import game.objects.weapons.Weapon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 * This is a Robot!
 * 
 * @author mahdi
 *
 */
public class Robot extends JComponent {

	/**
	 * Position of robot
	 */
	private Position pos;
	/**
	 * Weapons that robot carries them
	 */
	private ArrayList<Weapon> weapons;
	/**
	 * Healthy of robot
	 */
	private int health;
	/**
	 * Robot angle
	 */
	private double imageAngleRad = 0;
	/**
	 * mouse point
	 */
	private Point mousePoint;

	public Robot() {
		super();

		// Because of null layout of GameField.
		setLocation(0, 0);
		setSize(80, 80);

		pos = new Position(0, 0);
		// weapons = new ArrayList<Weapon>();
		health = 100;

		this.requestFocusInWindow();
		this.setFocusable(true);

		// Add multiple key listener
		this.addKeyListener(new KeyListener() {

			private final Set<Character> pressed = new HashSet<Character>();

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public synchronized void keyPressed(KeyEvent event) {
				// TODO Auto-generated method stub
				pressed.add(event.getKeyChar());
				java.util.Iterator<Character> iter = pressed.iterator();
				while (iter.hasNext()) {
					char s = iter.next();
					if (s == 'w') {
						pos.decY();
					}
					if (s == 's') {
						pos.incY((int) getToolkit().getScreenSize().getHeight());
					}
					if (s == 'd') {
						pos.incX((int) getToolkit().getScreenSize().getWidth());
					}
					if (s == 'a') {
						pos.decX();
					}

				}
			}

			@Override
			public synchronized void keyReleased(KeyEvent event) {
				// TODO Auto-generated method stub
				pressed.remove(event.getKeyChar());
			}
		});

		// Add mouse motion listener
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				mousePoint = e.getPoint();
				double dx = e.getX() - pos.getX();
				double dy = e.getY() - pos.getY();
				imageAngleRad = Math.atan2(dy, dx);

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public void paintComponent(Graphics g) {
		BufferedImage image = null;

		Graphics2D g2d = (Graphics2D) g;
		try {
			image = ImageIO
					.read(new File("src/game/images/robot/image 286.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		int cx = image.getWidth() / 2;
		int cy = image.getHeight() / 2;
		AffineTransform oldAT = g2d.getTransform();
		g2d.translate(cx + pos.getX(), cy + pos.getY());
		g2d.rotate(imageAngleRad);
		g2d.translate(-cx, -cy);
		g2d.drawImage(image, 0, 0, null);
		g2d.setTransform(oldAT);
	}
}
