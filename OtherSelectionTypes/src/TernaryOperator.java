import java.util.Scanner;

public class TernaryOperator
{
    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        
        System.out.println("Please enter two integer values-> ");
        int num1 = kybd.nextInt();
        int num2 = kybd.nextInt();
        int difference;
        
//        if (num1 > num2)
//        {
//            difference = num1 - num2;
//        }
//        else
//        {
//            difference = num2 - num1;
//        }
//        
        
        difference = num1 > num2 ? num1 - num2 : num2 - num1;

        System.out.println("The difference is: " + difference);
    }
}