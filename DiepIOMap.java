import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class DiepIOMap extends GameMap {
	
	Tank t = new Tank(Color.BLACK, 1 , 1, 10);
	Image background;
	
	public DiepIOMap() {
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
			URL url = getClass().getResource("images/background");
			background = ImageIO.read(url);
		} catch (IOException e) {
			System.out.println("Problem opening the background.png");
			e.printStackTrace();
		}
	}

}
