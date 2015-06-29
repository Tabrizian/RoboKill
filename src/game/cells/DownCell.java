package game.cells;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.Position;
import game.objects.Box;
import game.objects.Thing;
import game.objects.Wall;
import game.objects.prizes.Plunder;

public class DownCell extends Cell {

	public DownCell(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}
	
	public DownCell(int row, int column, Thing thing) {
		super( row , column , thing ) ;
	}
	
	public DownCell(int row, int column, Thing thing , Plunder plunder) {
		super( row , column , thing , plunder) ;
	}
	
	public DownCell(int row, int column, boolean isNoun) {
		super( row , column , isNoun ) ;
	}
	/**
	 * Loads image
	 */
	public void init(){
		try {
			image = new Image("pics/cells/image test4.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			exploded = new Image("pics/cells/image 1test4.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
