import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Graphics2D;

public class Tank extends GameObject {
	Image tank;
	public Tank(Color color, double x, double y, double size){
		super(color, x, y, size);
	}
	
	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub

	}
	
	public void draw(Graphics g){
		//g.drawRect((int)getX(), (int)getY(), (int)getSize(), (int)getSize());

		Graphics2D g2d=(Graphics2D)g; // Create a Java2D version of g.
		g2d.rotate(this.getPointingDirection());
		g2d.drawImage(tank, (int)this.getX(), (int)this.getY(), (int)this.getSize(), (int)this.getSize(), null);

		//g.fillOval((int)getX(), (int)getY(), (int)getSize(), (int)getSize());
	}
	
	public GameObject shoot() {
		Bullet b = new Bullet(Color.BLACK, this.getX(), this.getY(), 2);
		return b;
	}
	
// 	public shoot(Color color, double x, double y, double size, double damage){
// 		Bullet b = new Bullet(color, x, y, size, damage);
// 	}

}
