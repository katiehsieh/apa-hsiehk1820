//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Katie Hsieh

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
  private String[] wordRay;
  
  public WordSortTwo(String sentence)
  {
    wordRay = sentence.split(" ");
  }

  public void sort()
  {
    Arrays.sort(wordRay);
  }

  public String toString()
  {
    String output="";
    
    for (String item : wordRay) {
      output += item + "\n";
    }
    
    return output+"\n";
  }
}