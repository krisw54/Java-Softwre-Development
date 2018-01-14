import java.util.*;

public class Division
{
    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        try
        {
            System.out.println("Please enter two integers: ");
            int num1 = kybd.nextInt();
            int num2 = kybd.nextInt();
            int ans = num1 / num2;
            System.out.println("Answer is: " + ans);
        }
        catch (InputMismatchException ime)
        {
            System.out.println(ime.toString());
            System.out.println("Wrong type of input");
        }
        catch (ArithmeticException ae)
        {
            System.out.println("Divide by zero error");
        }
        catch (Exception ae)
        {
            System.out.println("You're on your own");
        }
    }
}