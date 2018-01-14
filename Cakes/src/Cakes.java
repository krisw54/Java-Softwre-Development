//input number and cost, calculate and output money taken
import java.util.*;
public class Cakes
{
    public static void main (String[] args)
    {
        //create Scanner to read in data
	Scanner myKeyboard = new Scanner(System.in);

	//prompt user for input
	//print leaves cursor on same line
	System.out.print("Enter number of cakes: ");
	int number = myKeyboard.nextInt();

	System.out.print("Enter cost of cakes: ");
	double cost = myKeyboard.nextDouble();

	//calculate and output money taken
        double money = number * cost;
        System.out.println("Money taken: " + money);
    }
}
