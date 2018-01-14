
import java.util.*;

public class PositiveSum
{

    public static void main(String[] args)
    {
        //form sum of positive integers
        Scanner myKeyboard = new Scanner(System.in);

        System.out.print("Enter integers to sum: ");
        int sum = 0;

        int num = myKeyboard.nextInt();
        while (num > -1)
        {
            sum = sum + num;
            //input next number 
            num = myKeyboard.nextInt();
        }

        System.out.println("Sum is: " + sum);

    }
}
