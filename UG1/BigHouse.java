//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Katie Hsieh
//Date - 2-28-19
//Class - 4
//Lab  - BigHouse

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class BigHouse extends Canvas
{
   public BigHouse()  //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      bigHouse(window);
   }

   public void bigHouse( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString( "BIG HOUSE ", 50, 50 );

      window.setColor(Color.BLUE);

      window.fillRect( 200, 200, 400, 400 );
      
      // roof
      window.setColor(Color.GREEN);
      int[] xPoints = {200, 600, 400};
      int[] yPoints = {200, 200, 0};
      window.fillPolygon(xPoints, yPoints, 3);
      
      // windows
      window.setColor(Color.YELLOW);
      window.fillRect(250, 250, 100, 100);
      window.fillRect(450, 250, 100, 100);
      
      // door
      window.setColor(Color.GRAY);
      window.fillRect(350, 400, 100, 200);

   }
}