import java.awt.Color;
import java.awt.Graphics;

public class DiepIOMap extends GameMap {

	
	public DiepIOMap() {
		addTank();
		
		
	}
	
	public void draw(Graphics g){
		Tank t = new Tank(Color.BLACK);
		t.draw(g);
	}
	
	
	private void addTank() {
		this.addGameObject(new Tank(Color.BLACK));
		
	}


	@Override
	public void openBackgroundImage() {
		// TODO Auto-generated method stub

	}

}
