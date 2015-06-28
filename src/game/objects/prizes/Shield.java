package game.objects.prizes;

import game.Position;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Shield extends Plunder {

	public Shield(Position pos) {
		// TODO Auto-generated constructor stub
		super(pos) ;
		init() ;
	}
	public Shield(){
		super() ;
		init() ;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		image.drawCentered(pos.getX(), pos.getY());
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			image = new Image("pics/plunder/image 601.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(GameContainer gc) {
		// TODO Auto-generated method stub

	}

}
