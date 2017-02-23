import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public abstract class GameMap {

	protected List<MovingObject> movers;
	Image backgroundImage;
	
	public GameMap() {
		movers = new ArrayList();
		openBackgroundImage();
	}

	public void addGameObject(GameObject go) {
		movers.add(go);
	}
	public abstract void openBackgroundImage(); 
	
	public abstract void draw(Graphics g);

	public void tick() {
		for(MovingObject m: movers){
			m.move();
		}
		
		
		
	}
	
	public void shoot() {
	}
}
