//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Katie Hsieh

import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
  //instance variables and other methods not shown

  private static int getNumDigits(int number)
  {
    int count = 0;
    
    while (number > 0) {
      number = number / 10;
      count++;
    }
    
    return count;
  }

  public static int[] getSortedDigitArray(int number)
  {
    int size = getNumDigits(number);
    int[] input = new int[size];
    
    for (int i = 0; i < size; i++) {
      input[i] = number % 10;
      number = number / 10;
    }
    
    // Insertion Sort
    for (int a = 1; a < size; a++) {
      int num = input[a];
      int b = a;
      
      while (b > 0 && num < input[b-1]) {
        // shift left until in correct spot
        input[b] = input[b-1];
        b--;
      }
      // switch values
      input[b] = num;
    }
    
    return input;
  }
  
}