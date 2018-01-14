import java.util.*;

public class AvgPosNeg
{
    public static void main(String[] args)
    {
        Scanner myKeyboard = new Scanner(System.in);
        System.out.println("Enter 10 integers Positive or Negitive: ");
        int countPos = 0;
        int countNeg = 0;
        int numPos = 0;
        int numNeg = 0;
        int num;
        
        for (int i = 0; i < 10; i++)
        {
            num = myKeyboard.nextInt();
            if (num >= 0)
            {
                numPos = numPos + num;
                num = 0;
                countPos++;
            }
            else
            {
                numNeg = numNeg + num;
                num = 0;
                countNeg++;
            }
        }
        System.out.println("Number of Positive Ints: " + numPos);
        System.out.println("Number of Negitive Ints: " + numNeg);
        System.out.println("");
        if (countPos > 0)
        {
            System.out.println("Average of Positive Ints: " + (numPos / countPos));
            System.out.println("Total Number of Positive Ints: " + countPos);
        }
        else
        {
          System.out.println("You didn't enter any positive ints");  
        }
        if (countNeg > 0)
        {
            System.out.println("Average of Negitive Ints: " + (numNeg / countNeg));
            System.out.println("Total Number of negative Ints: " + countNeg);
        }
        else
        {
            System.out.println("You didn't enter any negitive ints");
        }
    }
}