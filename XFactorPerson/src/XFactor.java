
import java.util.*;

public class XFactor
{

    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        ArrayList<Contestant> contestants = new ArrayList<Contestant>();

        System.out.print("Enter name of next contestant ('.' to finish) ");
        String name = kybd.nextLine();
        while (!name.equalsIgnoreCase("."))
        {
            System.out.print("Enter act of this contestant ");
            String act = kybd.nextLine();
            Contestant c = new Contestant();
            c.setName(name);
            c.setAct(act);
            contestants.add(c);
            System.out.print("Enter name of next contestant ('.' to finish) ");
            name = kybd.nextLine();
        }

        output(contestants);
    }

    public static void output(ArrayList<Contestant> contestants)
    {
        System.out.println("The contestants using standard for loop:");

        for (int i = 0; i < contestants.size(); i++)
        {
            Contestant c = contestants.get(i);
            System.out.println(c.getName() + " is a " + c.getAct());
        }



        System.out.println("\nThe contestants using for each loop:");
        for (Contestant c : contestants)
        {
            System.out.println(c.getName() + " is a " + c.getAct());
        }


    }
}
