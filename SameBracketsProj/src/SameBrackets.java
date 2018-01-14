
import java.util.Scanner;

/**
 *
 * @author krisw
 */
public class SameBrackets
{

    public static void main(String[] args)
    {

        Stack brackets = new Stack();

        Scanner kybd = new Scanner(System.in);
        System.out.print("Input or * to End : ");
        String action = kybd.nextLine();
        while (!action.equalsIgnoreCase("*"))
        {
            if (action.equalsIgnoreCase("("))
            {
                brackets.push(action);
            }
            else if (action.equalsIgnoreCase(")"))
            {
                if (brackets.isEmpty() == true)
                {
                    System.out.println("closing bracket with no matching opening bracket");
                }
                else
                {
                    brackets.pop();
                }
            }
            else
            {
                System.out.println("Invalid operation");
            }
            System.out.print("Input or * to End : ");
            action = kybd.nextLine();
        }
        if (brackets.isEmpty() == false)
        {
            System.out.println("opening bracket with no matching closing bracket");
        }
        else
        {
            System.out.println("well-formed brackets");
        }
    }
}
