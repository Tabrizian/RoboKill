package game.objects;

public class Box extends Thing {

	public Box() {
		// TODO Auto-generated constructor stub
		init();
	}

	@Override
	public void draw(float xPos, float yPos) {
		// TODO Auto-generated method stub
		image.drawCentered(xPos, yPos);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
