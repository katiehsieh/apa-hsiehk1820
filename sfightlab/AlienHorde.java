//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
  private List<Alien> aliens;
  private boolean game;

  public AlienHorde(int size)
  {
    game = true;
    aliens = new ArrayList<Alien>();
    for (int i = 0; i < size; i++) {
      add(new Alien((75 * i) + 50, 20, 30, 30, 1));
      add(new Alien((75 * i) + 50, 100, 30, 30, 1));
      add(new Alien((75 * i) + 50, 180, 30, 30, 1));
    }
  }

  public void add(Alien al)
  {
    aliens.add(al);
  }

  public void drawEmAll( Graphics window )
  {
    for (Alien item : aliens) {
      item.draw(window);
    }
  }

  public void moveEmAll()
  {
    for (Alien item : aliens) {
      if (item.getYD() < 570) {
        if (item.getXR() > 800 || item.getXR() < 0) {
          item.setY(item.getY() + 40);
          item.setSpeed(item.getSpeed() * -1);
        }
        item.move("RIGHT");
      }
      else {
        game = false;
      }
    }
  }

  public void removeDeadOnes(List<Ammo> shots)
  {
    for (int i = aliens.size() - 1; i >= 0; i--) {
      Alien alien = aliens.get(i);
      for (int j = shots.size() - 1; j >= 0; j--) {
        Ammo bullet = shots.get(j);
        boolean horiz = bullet.getX() < alien.getXR() && bullet.getXR() > alien.getX();
        boolean vert = bullet.getY() < alien.getYD() && bullet.getYD() > alien.getY();
        if (horiz && vert) {
          aliens.remove(i);
          shots.remove(j);
          break;
        }
      }
      if (getSize() == 0) {
        game = false;
      }
    }
  }
  
  public int getSize() {
    return aliens.size();
  }
  public boolean getGame() {
    return game;
  }
  
  public String toString()
  {
    return aliens.toString();
  }
}
