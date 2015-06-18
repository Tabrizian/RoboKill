package game;
import java.awt.BorderLayout;

import game.objects.Robot;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Game extends JFrame {

	/**
	 * Current working gamefield.
	 */
	private GameField field ;
	private Robot robot ;
	private JButton map ;
	private JButton inv ;
	private JButton menu ;
	private JLabel cash ;
	private JLabel shield ;
	
	/**
	 * Creates new Game with sample gamefield.
	 */
	public Game(){
		super("RoboKill");
		
		//Default gamefield.
		field = new GameField();
		setLayout(new BorderLayout());
		
		robot = new Robot();
		field.add(robot);
		
		//TODO will be changed to null layout later.
		add(field, BorderLayout.CENTER);
		
		setUndecorated(true);
		
		setVisible(true);
		//Exact size of game field.
		setSize(816, 639);
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
