//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Katie Hsieh
//Date - 2-28-19
//Class - 4
//Lab  - Shape

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapePanel extends JPanel
{
  public ShapePanel()
  {
    setBackground(Color.WHITE);
    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
  }

  /*
   * All of your test code should be placed in paint.
   */
  public void paint(Graphics window)
  {
    window.setColor(Color.WHITE);
    window.fillRect(0,0,getWidth(), getHeight());
    window.setColor(Color.BLUE);
    window.drawRect(20,20,getWidth()-40,getHeight()-40);
    window.setFont(new Font("TAHOMA",Font.BOLD,18));
    window.drawString("CREATE YOUR OWN SHAPE!",40,40);

    Shape test1 = new Shape(100, 100, 100, 100, Color.BLUE);
    test1.draw(window);

    Shape test2 = new Shape(500, 150, 150, 200, Color.CYAN);
    test2.draw(window);

    Shape test3 = new Shape(150, 300, 250, 150, Color.MAGENTA);
    test3.draw(window);
  }
}