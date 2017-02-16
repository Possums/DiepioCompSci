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
	private Image object;
	private Image tank, square, triangle, pentagon;
	private double damage, pointingDirection;
	
	
	public GameObject(Color color, double x, double y, double size) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.size = size;
		// assign damage
	}
	
	public void setDir(double d){
		direction = d;
	}
	
	public double getDirection(){
		return direction;
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

				URL url = getClass().getResource("images/tank.png");
				tank = ImageIO.read(url);
			} catch (Exception e) {
				System.out.println("problem opening the tank");
				e.printStackTrace();
			}
			try {

				URL url = getClass().getResource("images/square.png");
				square = ImageIO.read(url);
			} catch (Exception e) {
				System.out.println("problem opening the square");
				e.printStackTrace();
			}
			try {

				URL url = getClass().getResource("images/triangle.png");
				triangle = ImageIO.read(url);
			} catch (Exception e) {
				System.out.println("problem opening the triangle");
				e.printStackTrace();
			}
			try {

				URL url = getClass().getResource("images/hexagon.png");
				pentagon = ImageIO.read(url);
			} catch (Exception e) {
				System.out.println("problem opening the hexagon");
				e.printStackTrace();
			}
	}

	public abstract void checkOffScreen();
	
	public abstract void draw(Graphics g);
	
	
	@Override
	public Rectangle getBoundingRect() {
		
		return new Rectangle((int)x,(int)y,(int)size,(int)size);
	}
	
	public void takeDamage(GameObject go){
		this.health -= go.getDamage();
	}

	private double getDamage() {
		// TODO Auto-generated method stub
		return this.damage;
	}

	public double getPointingDirection() {
		return pointingDirection;
	}

	public void setPointingDirection(double pointingDirection) {
		this.pointingDirection = pointingDirection;
	}

}
