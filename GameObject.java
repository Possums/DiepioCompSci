import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;


public abstract class GameObject implements MovingObject {

	private double speed = 0;// 0 - 10
	private double direction = Math.PI / 2, // degrees or radians
			x= 0, y= 0, // >= 0

			size = 10, // 10 might be a good size   
			
			power = 10;// not sure about this...
	private int level = 1;//
	private Color color;
	private Image object;
	private Image square, triangle, pentagon;
	private BufferedImage tank;
	private double damage, movingDirection;
	private Rectangle rect;
	private String name;
	private int health = 100;


	public GameObject(Color color, double x, double y, double size) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.size = size;
		this.damage = 10;
		rect = new Rectangle();
		// assign damage
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setHealth(int health){
		this.health = health;
	}
	
	public int getHealth(){
		return this.health;
	}
	public void setDir(double d){
		setDirection(d);
	}

	public double getDirection(){
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public void setMovingDirection(double movingDirection){
		this.movingDirection = movingDirection;
	}

	public double getMovingDirection(){
		return this.movingDirection;
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
		x+= getSpeed()*Math.cos(getMovingDirection());
		y+= getSpeed()*Math.sin(getMovingDirection());
		if(this instanceof Bullet){
			//System.out.println(this);
		}
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

		return this.rect;
	}

	public void setBoundingRect(int x, int y, int width, int height){
		rect.setBounds(x, y, width, height);
	}

	public void takeDamage(GameObject go){
		this.health -= go.getDamage();
	}

	private double getDamage() {
		// TODO Auto-generated method stub
		return this.damage;
	}




	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public String toString(){
		String s = "";
		s+=this.getClass();
		s+=this.getX()+" , "+this.getY()+" speed: "+this.getSpeed()+" dir: "+this.getDirection();
		return s;
	}
}
