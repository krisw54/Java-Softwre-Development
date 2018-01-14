//think of a number and allow user to guess it
import java.util.*;

public class ThinkNumber
{
   public static void main (String args[])
   {
       Scanner kybd = new Scanner(System.in);

       //generate number in range 1-100
       int number = (int)(Math.random() * 100) + 1;
       int count = 1;

       System.out.print("Enter a number between 1 and 100: ");
       int guess = kybd.nextInt();

       //input guess until correct number
       while (guess != number)
       {
          if (guess < number)
          {
             System.out.print("Too low ");
          }
          else
          {
             System.out.print("Too high ");
          }

          guess = kybd.nextInt();
          count = count + 1;
       }

       //output count
       System.out.println("Correct - " + count + " guesses");
	}
}
       