import java.awt.Color;
import java.awt.Graphics;

public class DiepIOMap extends GameMap {
	
	Tank t = new Tank(Color.BLACK, 1 , 1, 10);

	
	public DiepIOMap() {
		addTank();
		
		
	}
	
	public void draw(Graphics g){
//		Tank t = new Tank(Color.BLACK, 1 , 1);
		t.draw(g);
	}
	
	
	private void addTank() {
		this.addGameObject(t);
		
	}


	@Override
	public void openBackgroundImage() {
		// TODO Auto-generated method stub

	}

}
