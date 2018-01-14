//check divisible by 3 and 5
import java.util.*;

public class Divisible
{
    public static void main (String args[])
    {
        Scanner myKeyboard = new Scanner(System.in);
	System.out.print("Enter number: ");
	int number = myKeyboard.nextInt();

        //check whether number is divisible by 3 and by 5
        if ((number % 3 == 0)  && (number % 5 == 0))
        {
            System.out.println("Divisible by 3 and 5");
        }
    }
}
