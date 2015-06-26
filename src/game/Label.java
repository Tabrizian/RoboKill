package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Label {

	private String imageAddress ;
	private Image image ;
	private String name ;
	private Image bar ;
	public Label( String name ){
		imageAddress = ("pics/labels/" + name + ".png") ;
		this.name = name ;
	}
	/**
	 * Loads images
	 */
	public void init(){
		try {
			image = new Image(imageAddress) ;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bar = new Image("pics/labels/bar.png") ;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Draws the label with Graphics g
	 * @param g
	 * @param shield
	 * @param cash
	 */
	public void draw( Graphics g , int shield , int cash){
		if( name.equals("shield")){
			image.draw(90, 0);
			bar.draw(96, 7, (float) (shield*1.33), 8);
		}
		else if( name.equals("cash")){
			image.draw(0, 0 , 86 , 20);
			String s = Integer.toString(cash) ;
			g.setColor(Color.decode("#f9b140"));
			g.setLineWidth(1);
			g.drawString(s, 41 , -2);
		}
	}
}
