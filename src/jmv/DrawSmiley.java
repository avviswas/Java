package jmv;

//Drawing a smiley face using colors and filled shapes.
import java.awt.Color;
import java.awt.Graphics; 
import javax.swing.JPanel; 
import javax.swing.JFrame;

public class DrawSmiley extends JPanel { 
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		
		//draw the face
		g.setColor(Color.yellow);
		g.fillOval(10, 10, 200, 200);
		
		 // draw the eyes
		/*g.setColor(Color.BLACK);
		g.fillOval(55, 65, 30, 30);
		g.fillOval(135, 65, 30, 30);
		
		// draw the mouth 
		g.fillOval(50, 110, 120, 60);
		
		// "touch up" the mouth into a smile
		g.setColor(Color.yellow);
		g.fillRect(50, 110, 120, 30);
		g.fillOval(50, 120, 120, 40);*/
	 } 
	
	 public static void main(String[] args) 
	 {
		 DrawSmiley panel = new DrawSmiley(); 
		 JFrame application = new JFrame(); 
		 application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 application.add(panel); 
		 application.setSize(230, 250); 
		 application.setVisible(true); 
		  
	 } // end class DrawSmiley
}