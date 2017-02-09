import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class MovingObjectsPanel extends JPanel {
	
	final Dimension defaultDim;// = new Dimension(800,600);
	GameMap gm;
	
	public MovingObjectsPanel() {
		this( new Dimension(800,600));
	}
	public MovingObjectsPanel(Dimension dim) {
		defaultDim = dim;
		this.setPreferredSize(defaultDim);
		makeGameMap();
	}
	private void makeGameMap() {
		gm = new DiepIOMap();
		
		//t = new Timer(0, ActionListener e);
	}
	
	private void setUpKeyMappings() {
		// maps keys with actions...
		//  The code below maps a KeyStroke to an action to be performed
		// In this case I mapped the space bar key to the action named "shoot"
		// Whenever someone hits the Space Bar the action shoot is sent out

		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"shoot");

		//  This associates the command shoot with some action.  In this 
		// case, the action triggers a shoot command invoked on my GameMap.  In general, whatever 
		// goes in the actionPerformed method will be executed when a shoot command
		// is sent...
			
		this.getActionMap().put("shoot",new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//gm.shoot();
			}
		});
		this.requestFocusInWindow();		
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
	
	private double calculateAngle(Point a){
		int objectX = (int) a.getX();
		int objectY = (int) a.getY();
		int adjacentSide = mouseX() - objectX;
		int oppositeSide = mouseY() - objectY;
		double angle = Math.atan(oppositeSide/adjacentSide);
		return  angle;
	}
	
	private void shoot() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		gm.draw(g);
	}

}
