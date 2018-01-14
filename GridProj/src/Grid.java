
import java.util.*;

public class Grid
{

    public static void main(String[] args)
    {

        Scanner myKeyboard = new Scanner(System.in);
        System.out.println("Enter width: ");
        int count = 0;
        int width;
        int height;

        width = myKeyboard.nextInt();

        if (width < 0)
        {
            width = myKeyboard.nextInt();
        }
        System.out.println("Enter height: ");
        height = myKeyboard.nextInt();

        if (height < 0)
        {
            height = myKeyboard.nextInt();
        }

        for (int i = 0; i < height; i++)
        {

            for (int j = 0; j < width; j++)
            {
                System.out.print("*");

            }
            System.out.println();
        }

    }
}
