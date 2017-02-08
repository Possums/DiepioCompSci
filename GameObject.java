import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;

import javax.imageio.ImageIO;


public abstract class GameObject implements MovingObject {

	private double speed = 0;// 0 - 10
	private double direction = Math.PI / 2, // degrees or radians
		x= 0, y= 0, // >= 0
	
	
		size = 10, // 10 might be a good size   
		health =100, // 0 - 100
		power = 10;// not sure about this...
	private int level = 1;//
	private Color color;
	private Image img;
	
	
	public GameObject(Color color, double x, double y) {
		this.color = color;
		this.x =x;
		this.y = y;
		
	}
	
	public double getX(){
		return x;
	}
	
	public void setX(int i){
		x = i;
	}
	
	public double getY(){
		return y;
	} 
	
	public void setY(int i){
		y = i;
	}
	
	public double getSize(){
		return size;
	}
	
	public double x(){
		return x;
	}

	@Override
	public void move() {
		x+= speed*Math.cos(direction);
		y+= speed*Math.sin(direction);
		
		checkOffScreen();
		// maybe "push" back onto the screen change direction if
		// this object goes off the screen
	}
	
	private void openImage() {
			try {

				URL url = getClass().getResource("cards/back.png"+ "");
				img = ImageIO.read(url);
			} catch (Exception e) {
				System.out.println("problem opening the card");
				e.printStackTrace();
			}
	}

	public abstract void checkOffScreen();
	
	public abstract void draw(Graphics g);
	
	
	@Override
	public Rectangle getBoundingRect() {
		
		return new Rectangle((int)x,(int)y,(int)size,(int)size);
	}

}