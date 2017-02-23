import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.awt.geom.Area;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.net.URL;

public class DiepIOMap extends GameMap {

	Dimension a = Toolkit.getDefaultToolkit().getScreenSize();
	Tank t = new Tank(Color.BLACK, a.width/2 , a.height/2, 200);
	TankBot TankBot = new TankBot(Color.BLACK, 100,100, 200);
	Image background;
	//Rectangle rect = new Rectangle((int)t.getX()+130, (int)t.getY()-33, 100, 65);
	int shouldShoot=0;
	boolean isBotDead = false;

	public DiepIOMap(Dimension d) {
		addTank();



	}

	public void tick(){
		if (isBotDead == true){
			
			//JOptionPane.showMessageDialog(null, "YOU WIN!");
		}
		super.tick();
		double angle = calculateAngle();

		if (shouldShoot % 8 == 0){
			botShoot();
		}
		shouldShoot++;

		for (int i =0; i<movers.size(); i++){

			((GameObject)movers.get(i)).setBoundingRect((int)((GameObject)movers.get(i)).getX(), (int)((GameObject)movers.get(i)).getY(), 20, 20);
			if (movers.get(i) instanceof Tank){
				t.setDir(angle);
				t.setBoundingRect((int)t.getX()+130, (int)t.getY()-33, 100, 65);
				if (t.getHealth() ==0 ){
					JOptionPane.showMessageDialog(null, "Game Over");
				}
			}
			if (movers.get(i) instanceof TankBot){
				TankBot.setSpeed(3);
				TankBot.setMovingDirection(botAngle());
				TankBot.setDirection(botAngle());
				TankBot.move();
				TankBot.setBoundingRect((int)TankBot.getX()+130, (int)TankBot.getY()-33, 100, 65);

				if (TankBot.getHealth() ==0){
					movers.remove(i);
					isBotDead = true;
					JOptionPane.showMessageDialog(null, "You Win!");
				}
			}
		}



		//		System.out.println("bot angle= " + Math.toDegrees(botAngle()));


		//		for (int i =0; i<movers.size(); i++){
		//			System.out.println("index = " + i + "  " + ((GameObject) movers.get(i)).getBoundingRect());
		//			
		//		}



		for (int i = 0; i < movers.size(); i++) {
			for (int j = i+1; j < movers.size(); j++) {
				// compare list.get(i) and list.get(j)
				//System.out.println("inner loop");


				if (movers.get(i).getBoundingRect().intersects(movers.get(j).getBoundingRect()) && 
						!((GameObject) movers.get(i)).getName().equals(((GameObject)movers.get(j)).getName())){
					System.out.println("collisions");

					((GameObject) movers.get(i)).takeDamage((GameObject) movers.get(j));
					((GameObject) movers.get(j)).takeDamage((GameObject) movers.get(i));
					try {
						if (movers.get(i) instanceof Bullet){
							movers.remove(i);
						}
					}
					catch (Exception e){
						System.out.println("error removing bullet");
					}
					try {
						if (movers.get(j) instanceof Bullet){
							movers.remove(j);
						}
					}
					catch (Exception e){
						System.out.println("error removing bullet");
					}
				}
			}
		}



	}

	public boolean isBotDead(){
		return isBotDead;
	}
	
	public void draw(Graphics g){
		//		Tank t = new Tank(Color.BLACK, 1 , 1);

		g.drawImage(background, 0, 0, a.width, a.height, null);
		//		t.draw(g);
		//		TankBot.draw(g);
		for (int i =0; i<movers.size(); i++){
			movers.get(i).draw(g);
		}
		if (isBotDead){
			g.setFont(new Font("TimesRoman", Font.PLAIN, 300)); 
			FontMetrics metrics = g.getFontMetrics();
			    // Determine the X coordinate for the text
			    int x = (3840 - metrics.stringWidth("You Win")) / 2;
			    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
			    int y = ((2160 - metrics.getHeight()) / 2) + metrics.getAscent();
			 
			g.drawString("You Win", x, y);
		}
	}

	public double getBotAngle(){
		return this.botAngle();
	}

	private void addTank() {
		this.addGameObject(t);
		this.addGameObject(TankBot);
	}

	public void shoot(){
		this.addGameObject(t.shoot());
	}

	public void botShoot(){
		this.addGameObject(TankBot.shoot(getBotAngle()));
	}

	public void moveDown(){
		//t.setY((int)(t.getY()-10));
		t.setMovingDirection((Math.PI/2));
		t.setSpeed(15);
	}

	public void moveUp(){
		//t.setY((int)(t.getY()+10));
		t.setMovingDirection((3*Math.PI/2));
		t.setSpeed(15);
	}

	public void moveRight(){
		//t.setX((int)(t.getX()+10));
		t.setMovingDirection(0);
		t.setSpeed(15);
	}

	public void moveLeft(){
		//t.setX((int)(t.getX()-10));
		t.setMovingDirection(Math.PI);
		t.setSpeed(15);
	}

	@Override
	public void openBackgroundImage() {
		// TODO Auto-generated method stub
		try {
			URL url = getClass().getResource("images/background.png");
			background = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("problem opening the background");
			e.printStackTrace();
		}

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
		Point imageCenter = new Point((int)t.getX() + 89, (int)t.getY() -50);
		double adjacentSide = mouseX() - imageCenter.x;
		double oppositeSide = mouseY() - imageCenter.y;
		double angle = Math.atan2(oppositeSide,adjacentSide);
		System.out.println(t.getX() + ", " +t.getY());
		//System.out.println("Height equals " + tank.getHeight(null) + "Width equals " + tank.getWidth(null));
		return  angle;
	}

	private double botAngle(){
		double adjacentSide = t.getX() - TankBot.getX();
		double oppositeSide = t.getY() - TankBot.getY();
		double angle = Math.atan2(oppositeSide,  adjacentSide);
		return angle;
	}

	public void stopTank() {
		// TODO Auto-generated method stub
		t.setSpeed(0);
	}

}
