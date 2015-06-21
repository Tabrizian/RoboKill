package game.objects.weapons.Blasters;

import org.newdawn.slick.GameContainer;

import game.Position;
import game.objects.weapons.Weapon;

public abstract class Blaster extends Weapon {

	public Blaster() {
		// TODO Auto-generated constructor stub
		super() ;
		//init() ;
	}
	
	public abstract void shot(float angleRad , Position pos ) ;
	public abstract void update(GameContainer gc);
	public abstract void init() ;
	public abstract void draw() ;

}
