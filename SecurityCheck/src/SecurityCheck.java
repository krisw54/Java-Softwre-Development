import java.util.*;

public class SecurityCheck
{
    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        String password = "abcdef";
        boolean access = true;
        
        int position = (int)(Math.random() * password.length()) + 1;      
        System.out.print("Which character is in position " + (position + 1) + "? ");
        String characterFromUser = kybd.nextLine();
        if (characterFromUser.charAt(0) != password.charAt(position))
        {
            access = false;
            System.out.println("Incorrect character");
        }
        else
        {
            System.out.println("Correct character");
        }
        
        char character = password.charAt((int)(Math.random() * password.length()));

        System.out.print("What is the position of the first " +
                         character + "? ");
        int positionFromUser = kybd.nextInt();
        if (positionFromUser - 1 != password.indexOf(character))
        {
            access = false;
            System.out.println("Incorrect position");
        }
        else
        {
            System.out.println("Correct position");
        }         
        if (!access)
        {
            System.out.println("Access denied");
        }
        else
        {
            System.out.println("Access granted");
        }
    }
}
