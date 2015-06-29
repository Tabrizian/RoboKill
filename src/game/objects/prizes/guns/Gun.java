package game.objects.prizes.guns;

import game.Position;
import game.objects.prizes.Plunder;

import org.newdawn.slick.GameContainer;

public abstract class Gun extends Plunder {

	public Gun(Position pos){
		super(pos) ;
		init() ;
	}
	public Gun(){
		super() ;
		init() ;
	}

}
