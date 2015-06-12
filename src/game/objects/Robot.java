package game.objects;

import game.Position;
import game.objects.weapons.Weapon;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * This is a Robot!
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

		pos = new Position(0, 0);
		weapons = new ArrayList<Weapon>();
		health = 100;

		this.requestFocusInWindow() ;
		this.setFocusable(true);
		
		//Add KeyListener for moving
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getKeyChar() == 'w') {
					pos.decY();
				}
				if (event.getKeyChar() == 's') {
					pos.incY((int) getToolkit().getScreenSize().getHeight());
				}
				if( event.getKeyChar() == 'd' ){
					pos.incX((int) getToolkit().getScreenSize().getWidth());
				}
				if( event.getKeyChar() == 'a' ){
					pos.decX();
				}
			}
		});
	}
	
	@Override
	public void paintComponent( Graphics g ){
		g.drawRect(pos.getX(), pos.getY(), 20, 20);
	}
}
