import java.util.*;

public class Countdown
{
    public static void main(String[] args)
    {
        //count down for lift off
        Scanner myKeyboard = new Scanner(System.in);
        System.out.print("Enter start value for count down: ");
        int start = myKeyboard.nextInt();

        //count back from starting point
        for (int count = start; count >= 0; count--)
        {
            System.out.println(count);
        }

        //blast off
        System.out.println("Blast off!");
    }
}
