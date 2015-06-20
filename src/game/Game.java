package game;

import game.objects.Robot;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {

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

	private Image fieldImage;
	private Image legOfRobot;
	private Image headOfRobot;
	private float current;

	// private int width = (int) getToolkit().getScreenSize().getWidth();
	// private int height = (int) getToolkit().getScreenSize().getHeight();

	/**
	 * Creates new Game with sample gamefield.
	 */
	public Game() {
		robot = new Robot();
		field = new GameField();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		fieldImage = new Image(field.getImage());
		legOfRobot = new Image(robot.getImageOfLeg());
		headOfRobot = new Image(robot.getImageOfBody());
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {

		fieldImage.draw(0, 0);

		legOfRobot.draw(robot.getPos().getX(), robot.getPos().getY());
		headOfRobot.setRotation(current);
		headOfRobot.draw(robot.getPos().getX(), robot.getPos().getY());

	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {

		float xPos = robot.getPos().getX();
		float yPos = robot.getPos().getY();

		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_UP)) {
			yPos -= 0.25;
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			yPos += 0.25;
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			xPos += 0.25;
		}
		if (input.isKeyDown(Input.KEY_LEFT)) {
			xPos -= 0.25;
		}

		robot.setPos(new Position(xPos, yPos));

		double dx = input.getMouseX() - robot.getPos().getX();
		double dy = input.getMouseY() - robot.getPos().getY();
		current = (float) (Math.atan2(dy, dx) - Math.PI / 2);
		current = (float) (current * 180 / Math.PI);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
}
