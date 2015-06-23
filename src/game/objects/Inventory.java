package game.objects;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Inventory {
	private ArrayList<AddOne> addOnes;
	private Image inventoryImage;
	private String inventoryAddress;
	
	public Inventory(){
		inventoryAddress = "pics/buttons/inv";
	}
	
	public void init(){
		for (AddOne addOne : addOnes) {
			try {
				addOne.imageInInventory = new Image(addOne.imageInInventoryAddress);
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void add(AddOne addOne){
		addOnes.add(addOne);
	}
	
}
