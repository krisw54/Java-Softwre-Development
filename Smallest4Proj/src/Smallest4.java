import java.util.*;
/**
 *
 * @author krisw
 */
public class Smallest4 {
    
    public static void main(String[] args) {
    
        smaller();
        
    }

    public static int smaller()
    {
        int num, smallest1 , smallest2;
        Scanner kybd = new Scanner(System.in);
        
        System.out.print("Please enter 4 numbers: ");
        num = kybd.nextInt();
        smallest1 = num;
        
        System.out.println("Please enter next number: ");
        num = kybd.nextInt();
        smallest2 = num;
               
        for (int i=0; i <2; i++)
        {
            if (smallest1 < smallest2)
            {
                smallest2 = num;
            }
        System.out.println("Please enter next number: ");
        num = kybd.nextInt();
        }
        System.out.println(" " + smallest1 + " " + smallest2 );
      return num;
   }
    
}
