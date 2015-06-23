package game.objects.weapons.Blasters;

import game.Position;

import org.newdawn.slick.GameContainer;

public class MediumBlaster extends Blaster {

	public MediumBlaster(int place){
		super( place ) ;
		name = "Medium Blaster" ;
		speed = (float) 5.88 ;
		price = 2100 ;
		power = 2 ;
	}

	@Override
	public void shot(float angleRad, Position pos , int robotWidth , int robotHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Position pos , int robotWidth , int robotHeight , float angle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
}
