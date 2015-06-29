package game.cells;

import game.objects.Thing;
import game.objects.prizes.Plunder;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class DownLeftCell extends Cell {

	public DownLeftCell(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}
	
	public DownLeftCell(int row, int column, Thing thing) {
		super( row , column , thing ) ;
	}
	
	public DownLeftCell(int row, int column, Thing thing , Plunder plunder) {
		super( row , column , thing , plunder) ;
	}
	public DownLeftCell(int row, int column, boolean isNoun) {
		super( row , column , isNoun ) ;
	}
	/**
	 * Loads image
	 */
	public void init(){
		try {
			image = new Image("pics/cells/image test6.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			exploded = new Image("pics/cells/image 1test6.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
