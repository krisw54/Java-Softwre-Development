
import java.util.Scanner;

/**
 *
 * @author krisw
 */
public class Reverse {
    
    public static void main(String[] args) {
        
        Scanner kybd = new Scanner(System.in);
        int[] tenNumbers = new int[10];
        System.out.println("Please enter 10 numbers");
        for (int i = 0; i < tenNumbers.length; i++)
        {
            System.out.println("Enter Next Number " + (i+1) + ": ");
            tenNumbers[i] = kybd.nextInt();
        }
        System.out.println();
        for (int i = tenNumbers.length-1; i >= 0; i--)
        {
            System.out.println(tenNumbers[i]);
        }
        
    }
    
}
