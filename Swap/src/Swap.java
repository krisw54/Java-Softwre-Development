//input 2 numbers, swap them and output them
import java.util.*;
public class Swap
{
    public static void main (String[] args)
    {
        Scanner myKeyboard = new Scanner(System.in);
		 System.out.print("Enter first number: ");
		 int a = myKeyboard.nextInt();
		 System.out.print("Enter second number: ");
		 int b = myKeyboard.nextInt();
        System.out.printf("Data before swap\na: %d, b: %d\n",
                          a, b);
		 //swap
        int temp = a;
        a = b;
        b = temp;
        System.out.printf("Data after swap\na: %d, b: %d\n",
                          a, b);
	}
}
