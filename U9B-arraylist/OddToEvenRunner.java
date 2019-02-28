//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Katie Hsieh
//Date - 2-27-19

import java.util.ArrayList;
import java.util.Arrays;

public class OddToEvenRunner
{
  public static void main( String args[] )
  {
    ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(7,1,5,3,11,5,6,7,8,9,10,12345,11));
    System.out.println(ListOddToEven.go(nums));
  }
}