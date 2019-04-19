//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block implements Collidable<Block>
{
  //instance variables
  private int speed;

  public Paddle()
  {
    super(10,10);
    speed =5;
  }


  //add the other Paddle constructors
  public Paddle(int x, int y, int w, int h, Color col, int s) {
    super(x, y, w, h, col);
    speed = s;
    
  }
  
  public Paddle(int x, int y, int w, int h, int s) {
    super(x, y, w, h);
    speed = s;
  }
  
  public Paddle(int x, int y, int s) {
    super(x, y);
    speed = s;
  }
  
  public Paddle(int x, int y) {
    super(x, y);
    speed = 5;
  }
  
  public void moveUpAndDraw(Graphics window)
  {
    //draw a white paddle at old paddle location
    window.setColor(Color.WHITE);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
    
    setY(getY()-speed);

    //draw the paddle at its new location
    window.setColor(getColor());
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }

  public void moveDownAndDraw(Graphics window)
  {
  //draw a white paddle at old paddle location
    window.setColor(Color.WHITE);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
    
    setY(getY()+speed);

    //draw the paddle at its new location
    window.setColor(getColor());
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }
  
  //add get methods
  public int getSpeed() {
    return speed;
  }
  
  public boolean didCollideLeft(Block b) {
    return false;
  }
  
  public boolean didCollideRight(Block b) {
    return false;
  }
  
  public boolean didCollideTop(Block b) {
    return getYT() == b.getYB();
  }
  
  public boolean didCollideBottom(Block b) {
    return getYB() == b.getYT();
  }
  
  //add a toString() method
  public String toString() {
    return super.toString() + "  " + speed;
  }
}