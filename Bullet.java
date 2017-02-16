import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Bullet extends GameObject{
	
	private Color color;
	
	private double speed = 10, size=2;
	
	private double damage = 10;
	private double direction;
	
	public Bullet(Color color, double x, double y, double size, double direction){
		super(color, x, y, size);
		this.direction = direction;
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
