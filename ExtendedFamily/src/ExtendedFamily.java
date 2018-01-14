import java.util.*;

public class ExtendedFamily
{
    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        Person[] family = new Person[4];
        
        for (int i = 0; i < family.length; i++)
        {
            family[i] = new Person();
        
            System.out.print("Enter full name: ");
            String firstname = kybd.next();
            String secondname = kybd.next();
            family[i].setName(firstname, secondname);
            System.out.print("Enter date of birth (dd mm yy) for " + family[i].getName() + ": ");
            int d = kybd.nextInt();
            int m = kybd.nextInt();
            int y = kybd.nextInt();
            family[i].setDOB(d, m, y);
        }

        for (int i = 0; i < family.length; i++)
        {
            System.out.println(family[i].getName() + ": " + family[i].getDOB());
        }
    }
}
