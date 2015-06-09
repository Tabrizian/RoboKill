package game.objects;
import game.Position;
import game.objects.weapons.Weapon;

import java.util.ArrayList;

import javax.swing.JComponent;


public class Robot extends JComponent {

	private Position pos ;
	private ArrayList<Weapon> weapons ;
	private int health ;
}
