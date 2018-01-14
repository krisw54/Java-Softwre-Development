//program to calculate and output cost of order after applyign discount if over 100 sold
import java.util.*;

public class Discount 
{
    public static void main (String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        System.out.print("Enter quantity: ");
        int quantity = kybd.nextInt();
        double cost = quantity * 0.5;

        //apply 10% discount if more than 100 items ordered
        if ( quantity > 100 )
        {
            cost = cost * 0.9;
        }
        System.out.println("Cost of order: " + cost);

    }
}
