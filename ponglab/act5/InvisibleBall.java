import java.awt.Color;
import java.awt.Graphics;

public class InvisibleBall extends Ball {
  InvisibleBall(int x, int y) {
    super(x, y);
  }
  
  public void moveAndDraw(Graphics window)
  {
  //draw a white ball at old ball location
    window.setColor(Color.WHITE);
    window.fillOval(getX(), getY(), getWidth(), getHeight());

    setX(getX()+getXSpeed());
    setY(getY()+getYSpeed());

    //draw the ball at its new location
    if (Math.random() < 0.3) {
      window.setColor(getColor());
      window.fillOval(getX(), getY(), getWidth(), getHeight());
    }
  }
}
