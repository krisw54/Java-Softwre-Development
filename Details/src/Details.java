//input and output name, age and address
import java.util.*;
public class Details
{
    public static void main (String[] args)
    {
        //create Scanner to read in data
        Scanner myKeyboard = new Scanner(System.in);

        //prompt user for input
        System.out.print("Enter name: ");
        String name = myKeyboard.nextLine();

        System.out.print("Enter age: ");
        int age = myKeyboard.nextInt();
        myKeyboard.nextLine(); //flush buffer

        System.out.print("Enter address: ");
        String address = myKeyboard.nextLine();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}
