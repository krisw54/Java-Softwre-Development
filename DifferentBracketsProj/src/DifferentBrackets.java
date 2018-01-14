
import java.util.Scanner;

/**
 *
 * @author krisw
 */
public class DifferentBrackets
{

    public static void main(String[] args)
    {
        Stack brackets = new Stack();
        int count = 1;
        int open= 1;
        Scanner kybd = new Scanner(System.in);
        System.out.print("Input or * to End : ");
        String action = kybd.nextLine();
        while (!action.equalsIgnoreCase("*"))
        {
            if (action.equalsIgnoreCase("(") || action.equalsIgnoreCase("{") || action.equalsIgnoreCase("["))
            {
                brackets.push(action);
            }
            else if (action.equalsIgnoreCase(")") || action.equalsIgnoreCase("}") || action.equalsIgnoreCase("]"))
            {
                if (brackets.isEmpty() == true)
                {
                    System.out.println("closing bracket with no matching opening bracket");
                }
                else if (action.equalsIgnoreCase(")"))
                {
                    if (brackets.check().equalsIgnoreCase("("))
                    {
                        brackets.pop();
                        count =1;
                    }
                    else
                    {
                        System.out.println("Missing Matching Open Bracket");
                    }
                }
                else if (action.equalsIgnoreCase("}"))
                {
                    if (brackets.check().equalsIgnoreCase("{"))
                    {
                        brackets.pop();
                        count ++;
                    }
                    else
                    {
                        System.out.println("Missing Matching Open Bracket");
                    }
                }
                else if (action.equalsIgnoreCase("]"))
                {
                    if (brackets.check().equalsIgnoreCase("["))
                    {
                        brackets.pop();
                        count ++;
                    }
                    else
                    {
                        System.out.println("Missing Matching Open Bracket");
                    }
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
            //if (action.equalsIgnoreCase("]")) 
            System.out.println("Miss Matched Brackets");
        }
        else if (count > 1)
        {
            System.out.println("Well Matched Nested Brackets");
        }
        else
        {
            System.out.println("Well Matched Brackets");
        }
    }

}
