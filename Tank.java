import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Tank extends GameObject {
	
	public Tank(Color color, double x, double y, double size){
		super(color, x, y, size);
	}
	
	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub

	}
	
	public void draw(Graphics g, double angle){
		//g.drawRect((int)getX(), (int)getY(), (int)getSize(), (int)getSize());
		g.fill3DRect((int)getX(), (int)getY(), (int)getSize(), (int)getSize(), false);
		g.rotate(angle);
	}

}
