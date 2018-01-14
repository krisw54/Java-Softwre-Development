
import java.util.*;


public class Triangle
{
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
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        }
    }
           
}