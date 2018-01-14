import java.util.*;
public class Greet 
{
    public static void main (String[] args)
    {
        //output personalised welcome message
        Scanner kybd = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = kybd.nextLine();

        //check title
        if (title.equalsIgnoreCase("Mrs") || title.equalsIgnoreCase("Ms"))
        {
            System.out.println("Hello Madam");
        }
        else if (title.equalsIgnoreCase("Miss"))
        {
            System.out.println("Hello young lady");
        }
        else if (title.equalsIgnoreCase("Mr"))
        {
            System.out.println("Hello Sir");
        }
        else
        {
            System.out.println("Hello");
        }
    }
}
