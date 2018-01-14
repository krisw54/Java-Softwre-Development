import java.util.*;
public class BankBalance 
{
    public static void main (String[] args)
    {
        //check user’s bank balance
        Scanner kybd = new Scanner(System.in);
        System.out.print("Enter balance: ");
        double balance = kybd.nextDouble();

        //output message giving status of account
        if ( balance < 0.0 )
        {
            System.out.println("Overdrawn");
        }
        else
        {
            System.out.println("In credit");
        }
    }
}
