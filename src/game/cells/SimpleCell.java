package game.cells;

import game.objects.Thing;
import game.objects.prizes.Plunder;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SimpleCell extends Cell {

	public SimpleCell(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}
	
	public SimpleCell(int row, int column, Thing thing , Plunder plunder) {
		super( row , column , thing , plunder) ;
	}
	
	public SimpleCell(int row, int column, Thing thing ) {
		super( row , column , thing ) ;
	}
	
	public SimpleCell(int row, int column, boolean isNoun) {
		super( row , column , isNoun ) ;
	}
	/**
	 * Loads image
	 */
	public void init(){
		try {
			image = new Image("pics/cells/image test.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
