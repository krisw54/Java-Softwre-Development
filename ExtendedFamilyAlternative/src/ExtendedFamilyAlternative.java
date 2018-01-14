
import java.util.*;

public class ExtendedFamilyAlternative
{

    private static Scanner kybd = new Scanner(System.in);

    public static void main(String[] args)
    {
        Person[] family = createFamily();
        
        printAllDetails(family);
    }

    public static Person[] createFamily()
    {
        Person[] family = new Person[4];

        for (int i = 0; i < family.length; i++)
        {
            System.out.println("Person" + (i + 1));
            family[i] = createPerson();
        }

        return family;
    }

    public static Person createPerson()
    {
        Person p = new Person();
        
        System.out.print("\tEnter full name: ");
        String firstname = kybd.next();
        String secondname = kybd.next();
        p.setName(firstname, secondname);
        
        System.out.print("\tEnter date of birth (dd mm yy) for " + p.getName() + ": ");
        int d = kybd.nextInt();
        int m = kybd.nextInt();
        int y = kybd.nextInt();
        p.setDOB(d, m, y);
        
        return p;
    }

    public static void printAllDetails(Person[] family)
    {
        for (int i = 0; i < family.length; i++)
        {
            System.out.println(family[i].getName() + ": " + family[i].getDOB());
        }
    }
}
