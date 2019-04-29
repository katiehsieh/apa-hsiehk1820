import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    mirrorRectangle(13, 27, 276, 97, true);
    /*
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
    */
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else {
          // check pixel below
          rightPixel = pixels[row+1][col];
          rightColor = rightPixel.getColor();
          if (leftPixel.colorDistance(rightColor) > 
              edgeDist)
            leftPixel.setColor(Color.BLACK);
          else
            leftPixel.setColor(Color.WHITE);
        }
      }
    }
  }
  
  /** Method to keep only blue values */
  public void keepOnlyBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray: pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  /** Method to negate all pixels */
  public void negate() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray: pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setBlue(255-pixelObj.getBlue());
      }
    }
  }
  
  /** Method to turn picture into shades of gray */
  public void grayscale() {
    grayscaleLumonisity();
  }
  
  /** Method to make fish easier to see in water */
  public void fixUnderwater() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray: pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(pixelObj.getRed() + 75);
        pixelObj.setGreen(pixelObj.getGreen() - 50);
        pixelObj.setBlue(pixelObj.getBlue() - 50);
      }
    }
  }
  
  /** Grayscale methods */
  public void grayscaleAverage() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray: pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setGrayAverage();
      }
    }
  }
  
  public void grayscaleLightness() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray: pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setGrayLightness();
      }
    }
  }
  
  public void grayscaleLumonisity() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray: pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setGrayLuminosity();
      }
    }
  }
  
  /** mirrors a picture vertically from right to left */
  public void mirrorVerticalRightToLeft() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }
  
  /** mirrors a picture horizontally from top to bottom */
  public void mirrorHorizontal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    int width = pixels[0].length;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++)
    {
      for (int col = 0; col < width; col++)
      {
        topPixel = pixels[row][col];
        botPixel = pixels[height - 1 - row][col];
        botPixel.setColor(topPixel.getColor());
      }
    }
  }
  
  /** mirrors a picture horizontally from bottom to top */
  public void mirrorHorizontalBotToTop() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    int width = pixels[0].length;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++)
    {
      for (int col = 0; col < width; col++)
      {
        topPixel = pixels[row][col];
        botPixel = pixels[height - 1 - row][col];
        topPixel.setColor(botPixel.getColor());
      }
    }
  }
  
  /** mirrors a picture diagonally */
  public void mirrorDiagonal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel pixelOne = null;
    Pixel pixelTwo = null;
    int square = Math.min(pixels.length, pixels[0].length);
    int width = square;
    int height = square;
    for (int row = 0; row < height; row++)
    {
      for (int col = 0; col < width; col++)
      {
        pixelOne = pixels[row][col];
        pixelTwo = pixels[col][row];
        pixelOne.setColor(pixelTwo.getColor());
      }
    }
  }
  
  /** Mirror the arms on the snowman */
  public void mirrorArms() {
    mirrorRectangle(103, 156, 172, 193, false);
    mirrorRectangle(238, 171, 295, 193, false);
  }
  
  /** Mirror the seagull */
  public void mirrorGull() {
    mirrorRectangle(229, 232, 342, 323, true);
  }
  
  
  /** Mirror refactor */
  public void mirrorRectangle(int x1, int y1, int x2, int y2, boolean vertical) {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    int mirrorPoint = 0;
    
    if (vertical) {
      // VERTICAL MIRROR
      mirrorPoint = x2;
      
      // loop through the rows
      for (int row = y1; row < y2; row++)
      {
        // loop from 13 to just before the mirror point
        for (int col = x1; col < mirrorPoint; col++)
        {
          
          leftPixel = pixels[row][col];      
          rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
          rightPixel.setColor(leftPixel.getColor());
        }
      }
    }
    else {
      // HORIZONTAL MIRROR
      mirrorPoint = y2;
      
      // loop through the rows
      for (int row = y1; row < mirrorPoint; row++)
      {
        // loop from 13 to just before the mirror point
        for (int col = x1; col < x2; col++)
        {
          
          leftPixel = pixels[row][col];      
          rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
          rightPixel.setColor(leftPixel.getColor());
        }
      }
    }
  }
  
  /** copy from the passed fromPic to the
   * specified startRow and startCol in the
   * current picture
   * @param fromPic the picture to copy from
   * @param startRow the start row to copy to
   * @param startCol the start col to copy to
   * @param endRow the end row to copy to
   * @param endCol the end col to copy to
   */
   public void copy2(Picture fromPic, int startRowPos, int startColPos,
                  int startRow, int startCol, int endRow, int endCol)
   {
     Pixel fromPixel = null;
     Pixel toPixel = null;
     Pixel[][] toPixels = this.getPixels2D();
     Pixel[][] fromPixels = fromPic.getPixels2D();
     for (int fromRow = startRow, toRow = startRowPos; 
          fromRow < endRow &&
          toRow < toPixels.length; 
          fromRow++, toRow++)
     {
       for (int fromCol = startCol, toCol = startColPos; 
            fromCol < endCol &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
       {
         fromPixel = fromPixels[fromRow][fromCol];
         toPixel = toPixels[toRow][toCol];
         toPixel.setColor(fromPixel.getColor());
       }
     }
   }
   
   /** Method to create a collage of several pictures */
   public void myCollage()
   {
     Picture flower1 = new Picture("flower1.jpg");
     flower1.zeroBlue();
     Picture flower2 = new Picture("flower1.jpg");
     flower2.mirrorDiagonal();
     Picture flower3 = new Picture("flower1.jpg");
     flower3.grayscale();
     this.copy(flower1,0,0);
     this.copy(flower2,100,0);
     this.copy(flower3,200,0);
     this.copy(flower1,300,0);
     this.copy(flower2,400,0);   
     this.copy(flower3,0,100);
     this.copy(flower1,100,100);
     this.copy(flower2,200,100);
     this.copy(flower3,300,100);
     this.copy(flower1,400,100);
     this.copy(flower2,0,200);
     this.copy(flower3,100,200);
     this.copy(flower1,200,200);
     this.copy(flower2,300,200);
     this.copy(flower3,400,200);
     this.mirrorVertical();
     this.write("collage.jpg");
   }
   
   /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection2(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        // check pixel right
        rightPixel = pixels[row][col+1];
        if (Math.abs(leftPixel.getAverage() - rightPixel.getAverage()) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else {
          // check pixel below
          rightPixel = pixels[row+1][col];
          if (Math.abs(leftPixel.getAverage() - rightPixel.getAverage()) > 
              edgeDist)
            leftPixel.setColor(Color.BLACK);
          else
            leftPixel.setColor(Color.WHITE);
        }
      }
    }
  }
  
  /** Method to blur an image within specified rectangle */
  public void blur(int x, int y, int w, int h)
  {
    Pixel pixel = null;
    Pixel[][] pixels = this.getPixels2D();
    for (int row = x; row < x + w; row++)
    {
      for (int col = y; col < y + h; col++)
      {
        pixel = pixels[row][col];
        
        int redSum = 0;
        int greenSum = 0;
        int blueSum = 0;
        int count = 0;
        
        for (int r = -1; r < 2; r++) {
          for (int c = -1; c < 2; c++) {
            if (row + r >= 0 && col + c >= 0) {
              redSum += pixels[row + r][col + c].getRed();
              greenSum += pixels[row + r][col + c].getGreen();
              blueSum += pixels[row + r][col + c].getBlue();
              count++;
            }
          }
        }
        
        int redAvg = redSum / count;
        int greenAvg = greenSum / count;
        int blueAvg = blueSum / count;
        
        pixel.setRed(redAvg);
        pixel.setGreen(greenAvg);
        pixel.setBlue(blueAvg);
       }
     }
   }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
