//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Katie Hsieh
//Date - 2-28-19
//Class - 4
//Lab  - Robot

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
  public Robot()    //constructor method - sets up the class
  {
    setSize(800,600);
    setBackground(Color.WHITE);   	
    setVisible(true);
  }
  
  public void paint( Graphics window )
  {
    window.setColor(Color.BLUE);
    
    window.drawString("Robot LAB ", 35, 35 );
    
    //call head method
    head(window);
    
    //call other methods
    upperBody(window);
    lowerBody(window);
  }
  
  public void head( Graphics window )
  {
    window.setColor(Color.BLACK);
    
    // head
    window.drawOval(300, 100, 200, 125);
    
    // eyes
    window.fillOval( 350, 155, 20, 20 );
    window.fillOval( 430, 155, 20, 20 );

    // mouth
    window.drawArc(355, 150, 90, 20, 180, 180);
  }

  public void upperBody( Graphics window )
  {
    // body
    window.drawOval(300, 225, 200, 225);
    
    // arms
    window.drawRect(250, 250, 50, 125);
    window.drawRect(500, 250, 50, 125);
  }

  public void lowerBody( Graphics window )
  {
    // legs
    window.drawRect(335, 450, 50, 75);
    window.drawRect(415, 450, 50, 75);
  }
}
