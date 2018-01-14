
import java.util.*;

public class Pension
{

    public static void main(String[] args)
    {
        Scanner myKeyboard = new Scanner(System.in);
        boolean valid = true;

        System.out.print("Enter gender: ");
        String gender = myKeyboard.next();

        System.out.print("Enter age: ");
        int age = myKeyboard.nextInt();

        if (!gender.equals("male") && !gender.equals("female"))
        {
            System.out.println("Gender must be male or female");
            valid = false;
        }

        if ((age < 18) || (age > 110))
        {
            System.out.println("Age must be between 18 and 110");
            valid = false;
        }

        if (valid)
        {
            if (gender.equals("male"))
            {
                if (age >= 65)
                {
                    System.out.println("Eligible male");
                } else
                {
                    System.out.println("Ineligible male");
                }
            } else //female
            {
                if (age >= 60)
                {
                    System.out.println("Eligible female");
                } else
                {
                    System.out.println("Ineligible female");
                }
            }
        }
    }
}
