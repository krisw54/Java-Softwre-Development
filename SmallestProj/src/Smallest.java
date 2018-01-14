import java.util.*;

public class Smallest
{
    public static void main(String[] args)
    {
        int num;
        int position;
        int smallest;
        
        Scanner kybd = new Scanner(System.in);
        
        System.out.println("Please enter 10 numbers: ");
        num = kybd.nextInt();
        
        smallest = num;
        position = 1;
        
        for (int i=2; i <= 10; i++)
        {
            System.out.println("Please enter next number: ");
            num = kybd.nextInt();
            if (num < smallest)
            {
                smallest = num;
                position = i;
            }
        }
        
        System.out.println("Smallest value found at " + position);
       
    }
    
}
