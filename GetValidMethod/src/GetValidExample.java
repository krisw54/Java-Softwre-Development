import java.util.*;
//get a valid value
public class GetValidExample
{
   public static void main (String [] args)
   {
      System.out.println("Value between 3 and 10: " + getValid(3, 10));    
      System.out.println("Value between 2 and 8: " + getValid(2, 8));
   }

   public static int getValid(int lower, int upper)
   {
      Scanner kybd = new Scanner(System.in);
      System.out.printf("Enter number between %d and %d: ", lower, upper); 
      int num = kybd.nextInt();

      while (num < lower || num > upper)
      {
          System.out.printf("Retry between %d and %d: ", lower, upper);
          num = kybd.nextInt();
      }
      return num;
   }
}
