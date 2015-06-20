package game.objects;

import game.Position;
import game.objects.weapons.Weapon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * This is a Robot!
 * 
 * @author mahdi
 *
 */
public class Robot {

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

	private String imageOfBody;
	private String imageOfLeg;

	// Screen size
	// private int width = (int) getToolkit().getScreenSize().getWidth();
	// private int height = (int) getToolkit().getScreenSize().getHeight();

	public Robot() {
		super();

		pos = new Position(70, 70);
		// weapons = new ArrayList<Weapon>();
		health = 100;

		imageOfBody = ("src/game/images/robot/image 286.png");
		imageOfLeg = ("src/game/images/robot/image 123.png");

		
	}

	/**
	 * set mouse point
	 * 
	 * @param p
	 */
	public void setMousePoint(Point p) {
		mousePoint = p;
	}

	/**
	 * get robot position
	 * 
	 * @return
	 */
	public Position getPos() {
		return pos;
	}

	/**
	 * Set an angle for robot rotating
	 * 
	 * @param r
	 */
	public void setImageAngle(double r) {
		imageAngleRad = r;
	}

	public String getImageOfBody() {
		return imageOfBody;
	}

	public String getImageOfLeg() {
		return imageOfLeg;
	}
	
	public void setPos(Position pos){
		this.pos = pos;
	}

}
