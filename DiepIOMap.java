import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.net.URL;

public class DiepIOMap extends GameMap {

	Tank t = new Tank(Color.BLACK, 1 , 1, 10);
	Image background;

	public DiepIOMap(Dimension d) {
		addTank();


	}

	public void draw(Graphics g){
		//		Tank t = new Tank(Color.BLACK, 1 , 1);
		t.draw(g);
	}


	private void addTank() {
		this.addGameObject(t);

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
