package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

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
	private int width = (int) getToolkit().getScreenSize().getWidth();
	private int height = (int) getToolkit().getScreenSize().getHeight();

	/**
	 * Create new Game with sample gamefield.
	 */
	public Game() {
		super("RoboKill");

		// Default gamefield.
		field = new GameField();
		setLayout(new BorderLayout());

		robot = new Robot();
		field.add(robot);

		// TODO will be changed to null layout later.
		add(field, BorderLayout.CENTER);

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				robot.setMousePoint(e.getPoint());
				double dx = e.getX() - robot.getPos().getX();
				double dy = e.getY() - robot.getPos().getY();
				robot.setImageAngle(Math.atan2(dy, dx) - Math.PI / 2);

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		setUndecorated(true);

		setVisible(true);
		// Exact size of game field.

		setSize(width * 59 / 100, height * 78 / 100);
		setLocation(width / 4, height / 9);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
