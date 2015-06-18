package game.objects;

import game.Position;
import game.objects.weapons.Weapon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

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
					
					//Updates its location for frame.
					setLocation(pos.getX(), pos.getY());
					//Updating main frame.
					getParent().revalidate();
				}
			}

			@Override
			public synchronized void keyReleased(KeyEvent event) {
				// TODO Auto-generated method stub
				pressed.remove(event.getKeyChar());
			}
		});

	}

	@Override
	public void paintComponent(Graphics g) {
		Image image = null;
		try {
			image = ImageIO
					.read(new File("src/game/images/robot/image 286.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.drawImage(image, 0, 0, null);
	}
}
