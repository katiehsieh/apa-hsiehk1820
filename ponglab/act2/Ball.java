//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200);
    setXSpeed(3);
    setYSpeed(1);
  }

  //add the other Ball constructors
  public Ball(int x, int y, int w, int h, Color col, int xSpd, int ySpd) {
    super(x, y, w, h, col);
    setXSpeed(xSpd);
    setYSpeed(ySpd);
  }
  
  public Ball(int x, int y, int w, int h, Color col) {
    super(x, y, w, h, col);
    setXSpeed(3);
    setYSpeed(1);
  }
  
  public Ball(int x, int y, int w, int h) {
    super(x, y, w, h);
    setXSpeed(3);
    setYSpeed(1);
  }
  
  public Ball(int x, int y) {
    super(x, y);
    setXSpeed(3);
    setYSpeed(1);
  }
  
  //add the set methods
  public void setXSpeed(int xSpd) {
    xSpeed = xSpd;
  }
  
  public void setYSpeed(int ySpd) {
    ySpeed = ySpd;
  }
  
  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
    window.setColor(Color.WHITE);
    window.fillOval(getX(), getY(), getWidth(), getHeight());

    setX(getX()+xSpeed);
    //setY
    setY(getY()+ySpeed);

    //draw the ball at its new location
    window.setColor(getColor());
    window.fillOval(getX(), getY(), getWidth(), getHeight());
  }
   
  public boolean equals(Object obj)
  {
    Ball b = (Ball)obj;
    return (xSpeed == b.getXSpeed()) && (ySpeed == b.getYSpeed());
  }
  
  //add the get methods
  public int getXSpeed() {
    return xSpeed;
  }
  
  public int getYSpeed() {
    return ySpeed;
  }

  //add a toString() method
  public String toString() {
    return super.toString() + "  " + xSpeed + " " + ySpeed;
  }
}