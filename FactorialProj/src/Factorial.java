
import java.util.*;
/**
 *
 * @author krisw
 */
public class Factorial {
    
    public static void main(String[] args) {
        
        System.out.println("Factorial is: " + factorial());
    }
                
    public static int factorial()
    {
     int num;
     Scanner kybd = new Scanner(System.in);
 
     System.out.println("Please enter a positive numnber: ");
     num = kybd.nextInt();
     System.out.print(num + "! = ");
     for (int i= (num -1); i > 0 ; i--)
     {
         System.out.print(i + " x ");
         num = num * i;
     }   
        System.out.println("");   
     return num;
    }
}

