
import java.util.*;

public class SumPosNeg {
    public static void main(String[] args) {
        
        Scanner myKeyboard = new Scanner(System.in);
        System.out.println("Enter 10 integers Positive or Negitive: ");
        int count = 0;
        int numPos = 0;
        int numNeg = 0;
        int num;
        
        for (int i = 0; i < 10; i++)
        {
            num = myKeyboard.nextInt();
            if (num >= 0)
            {
                numPos = numPos + num;
                num = 0;
                count++;
            }
            else
            {
                numNeg = numNeg + num;
                num = 0;
                count++;
            }
        }
        System.out.println("Number of Positive Ints: " + numPos);
        System.out.println("Number of Negitive Ints: " + numNeg);
        System.out.println("Number of times looped: " + count);
        
    }
}
