package game.objects ;
import game.Position;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
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
	// private ArrayList<Weapon> weapons;
	/**
	 * Healthy of robot
	 */
	private int health;

	public Robot() {
		super();

		pos = new Position(0, 0);
		// weapons = new ArrayList<Weapon>();
		health = 100;

		this.requestFocusInWindow();
		this.setFocusable(true);

		//Add multiple key listener
		this.addKeyListener(new KeyListener() {

			private final Set<Character> pressed = new HashSet<Character>();

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public synchronized void keyReleased(KeyEvent event) {
				// TODO Auto-generated method stub
				pressed.remove(event.getKeyChar());
			}

			@Override
			public synchronized void keyPressed(KeyEvent event) {
				// TODO Auto-generated method stub
				pressed.add(event.getKeyChar());
				if (pressed.size() > 1) {
					// More than one key is currently pressed.
					java.util.Iterator<Character> iter = pressed.iterator();
					while (iter.hasNext()) {
						char s = iter.next();
						if (s == 'w') {
							pos.decY();
						}
						if (s == 's') {
							pos.incY((int) getToolkit().getScreenSize()
									.getHeight());
						}
						if (s == 'd') {
							pos.incX((int) getToolkit().getScreenSize()
									.getWidth());
						}
						if (s == 'a') {
							pos.decX();
						}
					}
					// Iterate over pressed to get the keys.
				}

				else {
					if (event.getKeyChar() == 'w') {
						pos.decY();
					}
					if (event.getKeyChar() == 's') {
						pos.incY((int) getToolkit().getScreenSize().getHeight());
					}
					if (event.getKeyChar() == 'd') {
						pos.incX((int) getToolkit().getScreenSize().getWidth());
					}
					if (event.getKeyChar() == 'a') {
						pos.decX();
					}
				}
			}
		});

	}

	@Override
	public void paintComponent(Graphics g) {
		Image image = new ImageIcon(getClass().getResource(
				"Image\\Robot\\image 286.png")).getImage();
		g.drawImage(image, pos.getX(), pos.getY(), null);
	}
}
