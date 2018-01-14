
import java.util.*;


public class Equilateral {
    
        public static void main(String[] args)
    {
        Scanner myKeyboard = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows;

        rows = myKeyboard.nextInt();

        if (rows <= 0)
        {
            System.out.print("Enter rows: ");
            rows = myKeyboard.nextInt();
        }
        else
        {
        for (int i = rows; i > 0; i--)
        {
            for (int k = 0; k < rows; k++)
            {

            }
              for (int n = rows; n > i; n--)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++)
            {
                System.out.print(" *");
            }
            System.out.println("");
        }
        }
    }
}
