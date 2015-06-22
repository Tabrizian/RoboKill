package game.objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AddOnes {
	
	protected String imageInInventory;
	private Image img; 
	
	
	public void init(){
		try {
			img = new Image(imageInInventory);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
