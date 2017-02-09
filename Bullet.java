import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Bullet extends GameObject{
	
	private Color color;
	
	private double speed = 10, size=2;
	
	private double damage;
	
	
	public Bullet(Color color, double x, double y, double size, double damage){
		super(color, x, y, size);
		this.damage = damage;
	}


	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
