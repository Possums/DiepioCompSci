import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.net.URL;

public class DiepIOMap extends GameMap {
	
	Dimension a = Toolkit.getDefaultToolkit().getScreenSize();
	Tank t = new Tank(Color.BLACK, a.width/2 , a.height/2, 200);
	Image background;

	public DiepIOMap(Dimension d) {
		addTank();
		


	}

	public void draw(Graphics g){
		//		Tank t = new Tank(Color.BLACK, 1 , 1);
		
		g.drawImage(background, 0, 0, a.width, a.height, null);
		t.draw(g);
	}


	private void addTank() {
		this.addGameObject(t);

	}

	public void shoot(){
		//this.addGameObject(t.shoot());
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

}
