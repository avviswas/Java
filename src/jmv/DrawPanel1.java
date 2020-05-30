package jmv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Path2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//Created class DrawPanel1s
public class DrawPanel1
{
    public static void main(String[] args)
    {
        //invokeLater(Runnable) Causes doRun. run() to be executed asynchronously on the 
        //AWT event dispatching thread(EDT).This will happen after all pending AWT events have 
    	//been processed
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();// Calling createAndShowGUI function
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();  //Create a new frame to hold the panel
        
        //set the frame to exit when it is closed
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        f.getContentPane().add(new DrawStarShapePanel());//add the panel to the frame
        f.setSize(600, 600);//set the size of the frame
        f.setLocationRelativeTo(null);
        f.setVisible(true); //make the frame visible
    }

}

//Created DrawStarShapePanel class
class DrawStarShapePanel extends JPanel
{
    @Override
    protected void paintComponent(Graphics gr)
    {
    	// Let UI Delegate paint first, which 
        // includes background filling since 
        // this component is opaque.
        super.paintComponent(gr);
        
        //Graphics2D class extends the Graphics class to provide more sophisticated control 
        //over geometry, coordinate transformations, color management, and text layout
        Graphics2D g = (Graphics2D) gr;
        
        g.setColor(Color.WHITE);   //Set white color
        g.fillRect(0, 0, getWidth(), getHeight());  //fill rectangle
        
        //The RenderingHints class defines and manages collections of keys and associated
        //values which allow an application to provide input into the choice of algorithms used
        //by other classes which perform rendering and image manipulation services
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.BLACK);  //set black color
        g.draw(createDefaultStar(50, 200, 200));//Calling createDefaultStart function to draw star

        g.setPaint(Color.green);//set component color
        g.fill(createStar(400, 400, 40, 60, 10, 0));//Calling create start function and set color

        g.setPaint(new RadialGradientPaint(
            new Point(400, 200), 60, new float[] { 0, 1 }, 
            new Color[] { Color.PINK, Color.darkGray }));
        g.fill(createStar(400, 200, 20, 60, 8, 0)); //calling createStart function to draw star

        g.setPaint(new RadialGradientPaint(
            new Point(200, 400), 50, new float[] { 0, 0.3f, 1 }, 
            new Color[] { Color.blue, Color.MAGENTA, Color.ORANGE }));//Set component color
        g.fill(createStar(200, 400, 40, 50, 20, 0)); //calling createStart() and set color

    }

    //Created function to draw star
    private static Shape createDefaultStar(double radius, double centerX,
        double centerY)
    {
        return createStar(centerX, centerY, radius, radius * 2.63, 5,
            Math.toRadians(-18));
    }

    private static Shape createStar(double centerX, double centerY,
        double innerRadius, double outerRadius, int numRays,
        double startAngleRad)
    {
    	//The Double class defines a geometric path with coordinates stored in 
    	//double precision floating point.
        Path2D path = new Path2D.Double();
        
        //find the deltaAngleRad
        double deltaAngleRad = Math.PI / numRays;
        for (int i = 0; i < numRays * 2; i++)
        {
            double angleRad = startAngleRad + i * deltaAngleRad;
            double ca = Math.cos(angleRad);//returns the trigonometric cosine of an angle
            double sa = Math.sin(angleRad);//returns the trigonometric sin of an angle
            double relX = ca;
            double relY = sa;
            if ((i & 1) == 0)
            {
                relX *= outerRadius;
                relY *= outerRadius;
            }
            else
            {
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0)
            {
            	//class MoveTo extends PathElement. Creates an addition to the path by 
            	//moving to the specified coordinates.
                path.moveTo(centerX + relX, centerY + relY);
            }
            else
            {
            //LineTo class draws a line from the current position to specified x and y coordinate
                path.lineTo(centerX + relX, centerY + relY);
            }
        }
        path.closePath();
        return path;
    }
}//end of class