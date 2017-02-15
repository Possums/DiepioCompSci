import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public abstract class GameMap {

	private List<MovingObject> movers;
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
		// TODO Auto-generated method stub
		
	}
	
	public void shoot() {
		//Bullet b = new Bullet(Color.BLACK, x, y, size, damage);
	}
}
