//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Katie Hsieh
//Date - 2-27-19

import java.util.ArrayList;
import java.util.Arrays;

public class DownRunner
{
  public static void main( String args[] )
  {
    ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(-99,1,2,3,4,5,6,7,8,9,10,12345));
    System.out.println(ListDown.go(nums1));
    
    ArrayList<Integer> nums2 = new ArrayList<>(Arrays.asList(10,9,8,7,6,5,4,3,2,1,-99));
    System.out.println(ListDown.go(nums2));
  }
}