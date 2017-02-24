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

public class TankBot extends GameObject {
	Image tank;
	Dimension a = Toolkit.getDefaultToolkit().getScreenSize();
	Point center = new Point(a.width/2, a.height/2);
	Point imageCenter = new Point((int)this.getX(), (int)this.getY());
	private double maxHealth = 200;
	public TankBot(Color color, double x, double y, double size){

		super(color, x, y, size);
		openImage();
		this.setName("TankBot");
		this.setHealth(200);
	}

	@Override
	public void checkOffScreen() {
		// TODO Auto-generated method stub

	}

	public void draw(Graphics g){


		Point imagePosition = new Point((int)this.getX(), (int)this.getY());
		imageCenter = new Point((int)this.getX() + 89, (int)this.getY() -50);
		Graphics2D g2d=(Graphics2D)g; // Create a Java2D version of g.
		//System.out.println(tank.getHeight(null) + "height");
		//System.out.println(tank.getWidth(null)+ "");
		int cx = tank.getWidth(null) / 2;
		int cy = tank.getHeight(null) / 2;
		AffineTransform oldAT = g2d.getTransform();
		g2d.translate(cx+imageCenter.x, cy+imageCenter.y);
		g2d.rotate(this.getDirection());
		g2d.translate(-cx, -cy);
		g2d.drawImage(tank, 0, 0, null);
		g2d.setTransform(oldAT);
		g.drawRect((int)this.getX()+130, (int)this.getY()-33, 100, 65);
		g2d.drawRect((int)this.getX()+130, (int)this.getY() + 50, 100, 20);
		g2d.setColor(Color.RED);
		g2d.fillRect((int)this.getX()+130, (int)this.getY() + 50, (int)(this.getHealth()/maxHealth * 100), 20);
		g2d.setColor(Color.BLACK);

	}

	// 	public shoot(Color color, double x, double y, double size, double damage){
	// 		Bullet b = new Bullet(color, x, y, size, damage);
	// 	}

	public GameObject shoot(double botAngle) {

		Bullet b = new Bullet(Color.BLACK, this.getX() + 160, this.getY() + 10, 30, botAngle);
		//System.out.println("tank bot shoot");
		b.setName("TankBot");
		return b;

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
