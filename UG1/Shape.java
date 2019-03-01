//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Katie Hsieh
//Date - 2-28-19
//Class - 4
//Lab  - Shape

import java.awt.Color;
import java.awt.Graphics;

public class Shape
{
  //instance variables
  private int xPos;
  private int yPos;
  private int width;
  private int height;
  private Color color;

  public Shape(int x, int y, int wid, int ht, Color col)
  {
    xPos = x;
    yPos = y;
    width = wid;
    height = ht;
    color = col;
  }


  public void draw(Graphics window)
  {
    // color frame
    window.setColor(color);
    window.fillRect(xPos - 13, yPos - 13, width + 25, height + 25);  
    
    // white background
    window.setColor(color.WHITE);
    window.fillRect(xPos, yPos, width, height);
    
    // circles
    int xNew = (width / 2) + xPos - 37;
    int yNew = (height / 2) + yPos - 37;
    
    window.setColor(color);
    window.drawOval(xNew, yNew, 50, 50);
    window.drawOval(xNew+25, yNew, 50, 50);
    window.drawOval(xNew, yNew+25, 50, 50);
    window.drawOval(xNew+25, yNew+25, 50, 50);
  }

  
  //BONUS
  //add in set and get methods for all instance variables

  public int getxPos() {
    return xPos;
  }


  public void setxPos(int x) {
    xPos = x;
  }


  public int getyPos() {
    return yPos;
  }


  public void setyPos(int y) {
    yPos = y;
  }


  public int getWidth() {
    return width;
  }


  public void setWidth(int wid) {
    width = wid;
  }


  public int getHeight() {
    return height;
  }


  public void setHeight(int ht) {
    height = ht;
  }


  public Color getColor() {
    return color;
  }


  public void setColor(Color col) {
    color = col;
  }
  
  public String toString()
  {
    return xPos+" "+yPos+" "+width+" "+height+" "+color;
  }
}