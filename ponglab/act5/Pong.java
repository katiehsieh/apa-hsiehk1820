//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
  private SpeedUpBall ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  private Wall leftWall;
  private Wall rightWall;
  private Wall topWall;
  private Wall bottomWall;
  private Score score;
  
  private boolean[] keys;
  private BufferedImage back;
  
  private int width;
  private int height;
  private int playHeight;
  
  private static final Color red = Color.RED;
  private static final Color blue = Color.BLUE;
  private static final Color black = Color.BLACK;
  
  private static final int paddleWidth = 10;
  private static final int paddleHeight = 40;
  private static final int paddleSpeed = 5;
  private static final int paddleOffset = 50;
  
  private static final int wallThickness = 10;
  
  private static final int scoreHeight = 100;
  
  public Pong(int w, int h)
  {
    //set up all variables related to the game
    //GAME SIZE
    width = w;
    height = h;
    playHeight = height - scoreHeight;
    
    //BALL
    ball = new SpeedUpBall(width/2, playHeight/2);
    
    //PADDLES
    leftPaddle = new Paddle(paddleOffset, playHeight/2, paddleWidth, paddleHeight, red, paddleSpeed);
    rightPaddle = new Paddle(width - wallThickness - paddleOffset, playHeight/2, paddleWidth, paddleHeight, blue, paddleSpeed);
    
    //WALLS
    leftWall = new Wall(0, 0, wallThickness, playHeight, red);
    rightWall = new Wall(width - wallThickness, 0, wallThickness, playHeight, blue);
    topWall = new Wall(0, 0, width, wallThickness, black);
    bottomWall = new Wall(0, playHeight - wallThickness, width, wallThickness, black);
    
    //SCORE
    score = new Score(width, height, scoreHeight);
    
    keys = new boolean[4];

    
    setBackground(Color.WHITE);
    setVisible(true);
		
    new Thread(this).start();
    addKeyListener(this);		//starts the key thread to log key strokes
  }
	
  public void update(Graphics window){
    paint(window);
  }

  public void paint(Graphics window)
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();


    ball.moveAndDraw(graphToBack);
    leftPaddle.draw(graphToBack);
    rightPaddle.draw(graphToBack);
    leftWall.draw(graphToBack);
    rightWall.draw(graphToBack);
    topWall.draw(graphToBack);
    bottomWall.draw(graphToBack);
    score.draw(graphToBack);

    //see if ball hits left wall or right wall
    if (ball.didCollideLeft(leftWall) && ball.movingLeft()) {
      score.addScoreR();
      ball.resetDraw(graphToBack, width/2, (playHeight/2));
    }
    
    if (ball.didCollideRight(rightWall) && ball.movingRight()) {
      score.addScoreL();
      ball.resetDraw(graphToBack, width/2, (playHeight/2));
    }
    
    //see if the ball hits the top or bottom wall 
    if (ball.didCollideTop(topWall) || ball.didCollideBottom(bottomWall)) {
      ball.setYSpeed(ball.getYSpeed());
      ball.bounceY();
    }
    
    //see if the ball hits the left paddle
    if (ball.didCollideLeft(leftPaddle) && ball.movingLeft()) {
      ball.setXSpeed(ball.getXSpeed());
      ball.bounceX();
    }
    
    //see if the ball hits the right paddle
    if (ball.didCollideRight(rightPaddle) && ball.movingRight()) {
      ball.setXSpeed(ball.getXSpeed());
      ball.bounceX();
    }
    
    //see if the paddles need to be moved
    if (keys[0])
    {
      //move left paddle up and draw it on the window
      if (!leftPaddle.didCollideTop(topWall))
        leftPaddle.moveUpAndDraw(graphToBack);
    }
    if (keys[1])
    {
      //move left paddle down and draw it on the window
      if (!leftPaddle.didCollideBottom(bottomWall))
        leftPaddle.moveDownAndDraw(graphToBack);
    }
    if (keys[2])
    {
      //move right paddle up and draw it on the window
      if (!rightPaddle.didCollideTop(topWall))
        rightPaddle.moveUpAndDraw(graphToBack);
    }
    if (keys[3])
    {
      //move right paddle down and draw it on the window
      if (!rightPaddle.didCollideBottom(bottomWall))
        rightPaddle.moveDownAndDraw(graphToBack);
    }
    
    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'Z' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'M' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=false; break;
    case 'Z' : keys[1]=false; break;
    case 'I' : keys[2]=false; break;
    case 'M' : keys[3]=false; break;
    }
  }

  public void keyTyped(KeyEvent e){}
	
  public void run()
  {
    try
    {
      while(true)
      {
	Thread.currentThread().sleep(8);
	repaint();
      }
    }catch(Exception e)
    {
    }
  }	
}