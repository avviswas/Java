package jmv;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class DrawValue extends JFrame {
private DrawCanvas canvas;
private JTextField display;
private JLabel label;
private JSlider slider;
private JPanel p;

public DrawValue()
{      
   super( "DrawValue" );
   label = new JLabel( "Value:" );

   p = new JPanel();
   p.setLayout( new GridLayout( 1, 3 ) );

   canvas = new DrawCanvas();
   slider = new JSlider( SwingConstants.HORIZONTAL,
                           0, 200, 10 );
   slider.addChangeListener( 
     new ChangeListener() {
        public void stateChanged( ChangeEvent e )
        {
           canvas.setNumber( slider.getValue() );
           display.setText( String.valueOf( slider.getValue() ) );
        }
     }
   );
   display = new JTextField( "0", 5 );
   display.addActionListener(
      new ActionListener() {
         public void actionPerformed( ActionEvent e )
         {
            int v = Integer.parseInt( display.getText() );

            if ( v < slider.getMinimum() || v > slider.getMaximum() )
               return;

            canvas.setNumber( v );
            slider.setValue( v );
         }
      }
   );
   p.add( label );
   p.add( display );
   p.add( slider );

   getContentPane().add( canvas, BorderLayout.CENTER );
   getContentPane().add( p, BorderLayout.NORTH );
   setSize( 300, 300 );
   show();
}

public static void main( String args[] )
{
   DrawValue app = new DrawValue(); 

   app.addWindowListener(
      new WindowAdapter() {
         public void windowClosing( WindowEvent e )
         {
            System.exit( 0 );
         }
      }
   );
}
}

class DrawCanvas extends JPanel {
private int number;
private Font f;

public DrawCanvas()
{
   setBackground( Color.black );
   setSize( 200, 200 );
   f = new Font( "Serif", Font.BOLD, 99 );
}

public void setNumber( int n )
{
   number = n;
   repaint();
}

public void paintComponent( Graphics g )
{
   super.paintComponent( g );
   g.setFont( f );
   g.setColor( Color.red );
   g.drawString( String.valueOf( number ),
                 getSize().width / 2 - 40,
                 getSize().height / 2 );
}

public int getNumber()  { return number; }
}