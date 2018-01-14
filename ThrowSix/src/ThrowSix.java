import java.util.*;

public class ThrowSix
{
    public static void main(String[] args)
    {
        int dice = (int) (Math.random() * 6) + 1;
        int count = 1;

        while (dice != 6)
        {
            System.out.println("Throw: " + dice);
            count = count + 1;
            dice = (int) (Math.random() * 6) + 1;
        }


        System.out.println("Throw: " + dice);
        System.out.println("It took " + count
        + " goes to throw a 6");

    }
}
