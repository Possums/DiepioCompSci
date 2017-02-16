import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.imageio.ImageIO;

public class Tank extends GameObject {
	Image tank;
	Dimension a = Toolkit.getDefaultToolkit().getScreenSize();
	Point center = new Point(a.width/2, a.height/2);
	public Tank(Color color, double x, double y, double size){
		
		super(color, x, y, size);
		openImage();
	}

	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub

	}

	public void draw(Graphics g){
		//g.drawRect((int)getX(), (int)getY(), (int)getSize(), (int)getSize());
		
		Graphics2D g2d=(Graphics2D)g; // Create a Java2D version of g.
		
		//Point x = new Point((int)this.getX(), (int)this.getY());
		
		//System.out.println(mouseX());
//		AffineTransform backup = g2d.getTransform();
//		AffineTransform trans = new AffineTransform();
//		trans.rotate(calculateAngle(), (int)this.getX(), (int)this.getY());
//
//		g2d.transform(trans);
//		g2d.drawImage(tank, (int)this.getX(), (int)this.getY(), 2*(int)this.getSize(), (int)this.getSize(), null);
//
//
//		g2d.setTransform(backup); 
//		g2d.dispose();

		  	int cx = tank.getWidth(null) / 2;
	        int cy = tank.getHeight(null) / 2;
	        AffineTransform oldAT = g2d.getTransform();
	        g2d.translate(cx+this.getX(), cy+this.getY());
	        g2d.rotate(calculateAngle());
	        g2d.translate(-cx, -cy);
	        g2d.drawImage(tank, 0, 0, null);
	        g2d.setTransform(oldAT);
		
	}

	// 	public shoot(Color color, double x, double y, double size, double damage){
	// 		Bullet b = new Bullet(color, x, y, size, damage);
	// 	}
	
		public GameObject shoot() {
		Bullet b = new Bullet(Color.BLACK, this.getX(), this.getY(), 2);
		return b;
	}

	private int mouseX(){
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		return x;
	}

	private int mouseY(){
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int y = (int) b.getY();
		return y;
	}

	private double calculateAngle(){
		
		int adjacentSide = mouseX() - (int)this.getX();
		int oppositeSide = mouseY() - (int)this.getY();
		double angle = Math.atan2(oppositeSide,adjacentSide);
		System.out.println(Math.toDegrees(angle));
		return  angle;
	}

	private void openImage() {
		try {

			URL url = getClass().getResource("images/tank.png");
			tank = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("problem opening the tank");
			e.printStackTrace();
		}
	}
}
