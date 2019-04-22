//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

  //instance variables
  private int xSpeed;
  private int ySpeed;

  public SpeedUpBall()
  {
    super();
    xSpeed = 3;
    ySpeed = 1;
  }

  public SpeedUpBall(int x, int y)
  {
    super(x, y);
    xSpeed = 3;
    ySpeed = 1;
  }


  public SpeedUpBall(int x, int y, int xSpd, int ySpd)
  {
    super(x, y);
    xSpeed = xSpd;
    ySpeed = ySpd;
  }

  public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {
    super(x, y, wid, ht);
    xSpeed = xSpd;
    ySpeed = ySpd;
  }


  public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {
    super(x, y, wid, ht, col);
    xSpeed = xSpd;
    ySpeed = ySpd;
  }
  
  public void setXSpeed(int xSpd) {
    if (movingLeft())
      super.setXSpeed(xSpd - 1);
    else if (movingRight())
      super.setXSpeed(xSpd + 1);
  }
  
  public void setYSpeed(int ySpd) {
    if (movingUp())
      super.setYSpeed(ySpd - 1);
    else if (movingDown())
      super.setYSpeed(ySpd + 1);
  }
  
  public void resetDraw(Graphics window, int xPos, int yPos) {
    //reset speed
    xSpeed *= -1;
    super.setXSpeed(xSpeed);
    super.setYSpeed(ySpeed);
    
    //reset position
    window.setColor(Color.WHITE);
    window.fillOval(getX(), getY(), getWidth(), getHeight());
    setPos(xPos, yPos);
    window.setColor(getColor());
    window.fillOval(getX(), getY(), getWidth(), getHeight());
  }
}

