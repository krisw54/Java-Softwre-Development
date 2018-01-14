import java.util.*;

public class XFactor
{
    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        ArrayList<String> contestants = new ArrayList<String>();

        System.out.print("Enter name of next contestant ('.' to finish) ");
        String name = kybd.nextLine();
        while (!name.equalsIgnoreCase("."))
        {
            contestants.add(name);
            System.out.print("Enter name of next contestant ('.' to finish) ");
            name = kybd.nextLine();
        }

        output(contestants);
    }

    public static void output(ArrayList<String> contestants)
    {
        System.out.println("The contestants using standard for loop:");
        for (int i = 0; i < contestants.size(); i++)
        {
            System.out.println(contestants.get(i));
        }
        
        System.out.println("\nThe contestants using for each loop:");
        for (String candidate: contestants)
        {
            System.out.println(candidate);
        }
    }
}
