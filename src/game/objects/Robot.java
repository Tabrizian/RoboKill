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

	// Screen size
	private int width = (int) getToolkit().getScreenSize().getWidth();
	private int height = (int) getToolkit().getScreenSize().getHeight();

	public Robot() {
		super();

		// Because of null layout of GameField.
		setLocation(0, 0);
		setSize(width * 59 / 100, height * 78 / 100);

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
						// limited to size of Game frame
						pos.incY(height * 78 / 100);
					}
					if (s == 'd') {
						// limited to size of Game frame
						pos.incX(width * 59 / 100);
					}
					if (s == 'a') {
						pos.decX();
					}
					// Don't remove this line of code!!
					// Updates robot position.
					setLocation(pos.getX(), pos.getY());

					double dx = mousePoint.getX() - pos.getX();
					double dy = mousePoint.getY() - pos.getY();
					imageAngleRad = Math.atan2(dy, dx) - Math.PI / 2;
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
				imageAngleRad = Math.atan2(dy, dx) - Math.PI / 2;

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public void paintComponent(Graphics g) {
		BufferedImage body = null;

		Graphics2D g2d = (Graphics2D) g;
		try {
			body = ImageIO
					.read(new File("src/game/images/robot/image 286.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedImage leg = null;
		try {
			leg = ImageIO.read(new File("src/game/images/robot/image 123.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		g2d.drawImage(leg, pos.getX(), pos.getY(), null);

		// Rotate robot
		int cx = body.getWidth() / 2;
		int cy = body.getHeight() / 2;
		AffineTransform oldAT = g2d.getTransform();
		g2d.translate(cx + pos.getX(), cy + pos.getY());
		g2d.rotate(imageAngleRad);
		g2d.translate(-cx, -cy);
		g2d.drawImage(body, 0, 0, null);
		g2d.setTransform(oldAT);
	}
}
