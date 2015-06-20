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
		field.init();
		robot.init();
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {

		field.draw();
		robot.draw();

	}

	@Override
	public void update(GameContainer gc, StateBasedGame arg1, int arg2)
			throws SlickException {

		robot.update(gc);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
