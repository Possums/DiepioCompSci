import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Tank extends GameObject {
	
	public Tank(Color color, double x, double y){
		super(color, x, y);
	}
	
	public double calcDir(double x, double y){
		return double direction = Math.atan(x/y);
	}
	
	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub

	}
	
	public void draw(Graphics g){
		//g.drawRect((int)getX(), (int)getY(), (int)getSize(), (int)getSize());
		g.fill3DRect((int)getX(), (int)getY(), (int)getSize(), (int)getSize(), false);
	}

}
