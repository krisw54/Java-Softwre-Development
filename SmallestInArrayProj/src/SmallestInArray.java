import java.util.Scanner;

/**
 *
 * @author krisw
 */
public class SmallestInArray {
    
    public static void main(String[] args) {
        
        Scanner kybd = new Scanner(System.in);
        int[] tenNumbers = new int[10];
        System.out.println("Please enter 10 numbers");
        for (int i = 0; i < tenNumbers.length; i++)
        {
            System.out.println("Enter Next Number " + (i+1) + ": ");
            tenNumbers[i] = kybd.nextInt();
        }
        
        int numTest = tenNumbers[0];
        int pos=0;
        
        for (int i = 0; i < tenNumbers.length; i++)
        {
           if (tenNumbers[i] < numTest)
           {
                numTest = tenNumbers[i];
                pos = i;
           }

        }
        System.out.println("The Smallest Numnber is: " + numTest + "\nIn Posistion In Array " + pos);
    }
    
}
