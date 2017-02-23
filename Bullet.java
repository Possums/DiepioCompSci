import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Bullet extends GameObject{


	public Bullet(Color color, double x, double y, double size, double direction){
		super(color, x, y, size);
		this.setMovingDirection(direction);
		setSpeed(30);
		this.setHealth(100000);
	}


	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub
		
	}


	
	@Override
	public void draw(Graphics g) {
//		this.setBoundingRect((int)this.getX(), (int)this.getY(), 20, 20);
//		g.drawRect((int)this.getX(), (int)this.getY(),30,30);
		g.fillOval((int)getX(), (int)getY(), (int)getSize(), (int)getSize());		
	}
	
	
}
