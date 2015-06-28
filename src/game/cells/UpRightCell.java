package game.cells;

import game.objects.Thing;
import game.objects.prizes.Plunder;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class UpRightCell extends Cell {

	public UpRightCell(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}
	
	public UpRightCell(int row, int column, Thing thing , Plunder plunder) {
		super( row , column , thing , plunder) ;
	}
	
	public UpRightCell(int row, int column, Thing thing ) {
		super( row , column , thing ) ;
	}
	
	public UpRightCell(int row, int column, boolean isNoun) {
		super( row , column , isNoun ) ;
	}
	/**
	 * Loads image
	 */
	public void init(){
		try {
			image = new Image("pics/cells/image test7.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
