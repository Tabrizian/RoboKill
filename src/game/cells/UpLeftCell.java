package game.cells;

import game.objects.Thing;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class UpLeftCell extends Cell {

	public UpLeftCell(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}
	
	public UpLeftCell(int row, int column, Thing thing) {
		super( row , column , thing ) ;
	}
	
	public UpLeftCell(int row, int column, boolean isNoun) {
		super( row , column , isNoun ) ;
	}
	
	public void init(){
		try {
			image = new Image("pics/cells/image test5.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
