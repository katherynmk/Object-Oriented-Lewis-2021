// Write a program that will determine and print the mean, median, and mode of the numbers 17, 21, 14, 8, 9, 12, 15, 21, and 7. 
// Your program should compute the mean, but you can simply report the median and mode instead of computing them if you wish.
// Report the mean with two digits after the decimal point. Call the program LastnameStatistics.java (4 points)
import java.util.*;

public class KnutsonStatistics {
   public static void main(String []args){

      List<Integer> numbers = Arrays.asList(17, 21, 14, 8, 9, 12, 15, 21, 7);

      double sum = 0.00;

      for (int i : numbers) {
         sum = sum + i;
      }
      
         System.out.println("The mean of this list of numbers is: " + sum/numbers.size());
         // I could not figure out two decimal points with float or double, so its more than two :)
         System.out.println("The median of this list of numbers is: 14 ");
         System.out.println("The mode of this list of numbers is: 21 ");

      }
   }
