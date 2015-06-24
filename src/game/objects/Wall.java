package game.objects;

public class Wall extends Thing {

	public Wall() {
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
