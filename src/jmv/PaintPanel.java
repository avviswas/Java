package jmv;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintPanel extends JPanel
{
  // PROPERTIES
  private final int DEFAULT_WIDTH  = 800;//Declare private final variable
  private final int DEFAULT_HEIGHT = 800;
  private final Color BACK_COLOR   = Color.WHITE;

  private int x1, y1, x2, y2;  //Declare x and y parameters 

  private MyMouseHandler handler; //Declaration of Mouse event
  private Graphics g;

  // CONSTRUCTOR
  public PaintPanel()
  {
    setBackground( BACK_COLOR );  //Set the background color
    setPreferredSize( new Dimension( DEFAULT_WIDTH, DEFAULT_HEIGHT ) );

    handler  = new MyMouseHandler();

    this.addMouseListener( handler );  //Register Event handler
    this.addMouseMotionListener( handler ); //Register Event handler
  }

  // METHOD
  public void paintComponent(Graphics g)
  {
	//call paintComponent to ensure the panel displays correctly
    super.paintComponent(g);
  }

  private void setUpDrawingGraphics()
  {
	  //calling getGraphics method
    g = getGraphics();
  }

  // INNER CLASS
  private class MyMouseHandler extends MouseAdapter{
    public void mousePressed( MouseEvent e ){
      x1 = e.getX(); //getting value for x1
      y1 = e.getY(); //getting value for y1

      System.out.println("Mouse is being pressed at X: " + x1 + " Y: " + y1);

      setUpDrawingGraphics();

      x2=x1;
      y2=y1;
    }
    //Mouse dragged method
    public void mouseDragged( MouseEvent e ){
      x1 = e.getX();  //getting value for x1
      y1 = e.getY(); //getting value for y1

     System.out.println("Mouse is being dragged at X: " + x1 + " Y: " + y1);  

    // this is drawing line between the points(x1, y1) and (x2, y2)
      g.drawLine(x1,y1,x2,y2);

      x2=x1;
      y2=y1;
    }
  }
}