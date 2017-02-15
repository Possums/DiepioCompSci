import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.net.URL;

import javax.imageio.ImageIO;

public class Tank extends GameObject {
	Image tank;
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

		g2d.drawImage(tank, (int)this.getX(), (int)this.getY(), (int)this.getSize(), (int)this.getSize(), null);
		Point x = new Point((int)this.getX(), (int)this.getY());
		g2d.rotate(calculateAngle());
		//System.out.println(mouseX());
		

	}

	// 	public shoot(Color color, double x, double y, double size, double damage){
	// 		Bullet b = new Bullet(color, x, y, size, damage);
	// 	}

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
		
		int adjacentSide = mouseX();
		int oppositeSide = mouseY();
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
