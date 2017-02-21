import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Bullet extends GameObject{

	
	public Bullet(Color color, double x, double y, double size, double direction){
		super(color, x, y, size);
		this.setDirection(direction);
		setSpeed(10);
	}


	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void draw(Graphics g) {
		g.fillOval((int)getX(), (int)getY(), (int)getSize(), (int)getSize());		
	}
	
	
}
