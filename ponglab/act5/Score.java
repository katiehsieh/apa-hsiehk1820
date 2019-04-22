import java.awt.Color;
import java.awt.Graphics;

public class Score {
  private int scoreL;
  private int scoreR;
  private int width;
  private int height;
  private int offsetY;
  private static final int offsetX = 100;
  
  public Score(int w, int h, int scoreH) {
    scoreL = 0;
    scoreR = 0;
    width = w;
    height = h - scoreH;
    offsetY = scoreH/2;
  }
  
  public void resetScore() {
    scoreL = 0;
    scoreR = 0;
  }
  
  public void addScoreL() {
    scoreL++;
  }
  
  public void addScoreR() {
    scoreR++;
  }
  
  public void draw(Graphics window) {
    window.setColor(Color.LIGHT_GRAY);
    window.fillRect(0, height, width, height);
    
    window.setColor(Color.RED);
    window.drawString("Player 1: " + scoreL, offsetX/4, height + offsetY);
    window.setColor(Color.BLUE);
    window.drawString("Player 2: " + scoreR, width - offsetX, height + offsetY);
  }
}
