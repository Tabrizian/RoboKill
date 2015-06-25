package game.cells;

import game.objects.Thing;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LeftCell extends Cell {

	public LeftCell(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}
	
	public LeftCell(int row, int column, Thing thing) {
		super( row , column , thing ) ;
	}
	
	public LeftCell(int row, int column, boolean isNoun) {
		super( row , column , isNoun ) ;
	}
	
	public void init(){
		try {
			image = new Image("pics/cells/image test1.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
