package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.objects.Robot;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Game extends JFrame {

	/**
	 * Current working gamefield.
	 */
	private GameField field;
	private Robot robot;
	private JButton map;
	private JButton inv;
	private JButton menu;
	private JLabel cash;
	private JLabel shield;
	private int width = (int) getToolkit().getScreenSize().getWidth() ;
	private int height = (int) getToolkit().getScreenSize().getHeight() ;
	/**
	 * Creates new Game with sample gamefield.
	 */
	public Game() {
		super("RoboKill");

		Timer timer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();

		// Default gamefield.
		field = new GameField();
		setLayout(new BorderLayout());

		robot = new Robot();
		field.add(robot);

		// TODO will be changed to null layout later.
		add(field, BorderLayout.CENTER);

		setUndecorated(true);

		setVisible(true);
		// Exact size of game field.
		setSize(width*59/100, height*78/100);
		setLocation(width/4, height/9);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
