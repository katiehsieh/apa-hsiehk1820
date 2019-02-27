//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Katie Hsieh
//Date - 2-25-19
//Class - 4
//Lab  - SmileyFace

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class SmileyFace extends Canvas
{
   public SmileyFace()    //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      smileyFace(window);
   }

   public void smileyFace( Graphics window )
   {
      window.setColor(Color.BLUE);
      window.drawString("SMILEY FACE LAB ", 35, 35);

      window.setColor(Color.YELLOW);
      window.fillOval( 210, 100, 400, 400 );

		//add more code here
      window.setColor(Color.BLACK);
      window.fillOval( 310, 250, 30, 30 );
      window.fillOval( 500, 250, 30, 30 );

      window.drawArc(310, 400, 150, 50, 0, 180);

   }
}
