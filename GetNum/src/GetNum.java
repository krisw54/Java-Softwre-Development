import java.util.*;

public class GetNum
{

    public static void main(String[] args)
    {
        int validNum = validateNum();
        System.out.println(validNum);
    }

    //method to input valid data
    public static int validateNum()
    {
        Scanner kybd = new Scanner(System.in);
        boolean OK = false;
        int num = 0;
        System.out.print("Please enter an integer: ");
        while (!OK)
        {
            try
            {
                num = kybd.nextInt();
                OK = true;
            } 
            catch (InputMismatchException e)
            {
                System.out.print("Invalid input, try again: ");
                kybd.nextLine();
            }
        }
        return num;
    }
}
