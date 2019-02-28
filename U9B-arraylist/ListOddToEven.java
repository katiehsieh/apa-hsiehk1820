//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Katie Hsieh
//Date - 2-27-19

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
  public static int go( List<Integer> ray )
  {
    int oddPos = -1;
    int evenPos = -1;
    
    for (int a = 0; a < ray.size(); a++) {
      if (Math.abs(ray.get(a)) % 2 != 0) {
        oddPos = a;
        
        for (int b = oddPos + 1; b < ray.size(); b++) {
          if (Math.abs(ray.get(b)) % 2 == 0) {
            evenPos = b;
          }
        }
        
        break;
      }
    }
    
    if (oddPos == -1 || evenPos == -1) {
      return -1;
    }
    else {
      return evenPos - oddPos;
    }
    
  }
}