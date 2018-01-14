
import java.util.*;

public class CountPos
{

    public static void main(String[] args)
    {
        Scanner myKeyboard = new Scanner(System.in);
        System.out.print("Enter 10 integers: ");
        int count = 0;
        int num;

        for (int i = 0; i < 10; i++)
        {
            num = myKeyboard.nextInt();
            if (num >= 0)
            {
                count++;
            }
        }
        System.out.println(count + " positive integers");
    }
}
