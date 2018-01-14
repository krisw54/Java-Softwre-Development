import java.util.Scanner;

public class CompanyPersonPetApplication
{
    public static void main(String args[])
    {
        Scanner kybd = new Scanner(System.in);
        
        System.out.print("Please enter your university username: > ");
        String yourName = kybd.nextLine();
        
        System.out.println("*********************************************");
        System.out.printf("%-5s Results from: %-20s %4s\n", "*", yourName, "*");
        System.out.println("*********************************************");
        
        Person tim = new Person("Timmy");
        Person sam = new Person("Sammy");
        Person tina = new Person("Tina");
        Person joe = new Person("Joe");
        Pet fluffy = new Pet("Fluffy");
        Pet growler = new Pet("Growler");
        Pet snarler = new Pet("Snarler");
        Company uniCo = new Company("UniCo", "Beaconside");
        Company logiLtd = new Company("LogiLtd", "Walton");
        
        System.out.print("\n");
        printPersonDetails(tim);
        printPersonDetails(sam);
        printPersonDetails(tina);
        printPersonDetails(joe);
        
        tim.setPet(fluffy);
        tim.setCompany(uniCo);
        
        sam.setPet(growler);
        
        tina.setPet(snarler);
        tina.setCompany(logiLtd);
        
        joe.setCompany(uniCo);
        
        System.out.print("\n");
        printPersonDetails(tim);
        printPersonDetails(sam);
        printPersonDetails(tina);
        printPersonDetails(joe);
    }
    
    private static void printPersonDetails(Person p)
    {
        System.out.print(p.getName());
        
        if (p.getPet() == null)
        {
            System.out.print(" does not have a pet");
        }
        else
        {
            System.out.print(" has a pet called " + p.getPet().getName());
        }
        
        if (p.getCompany() == null)
        {
            System.out.println(", and does not have a job");
        }
        else
        {
            System.out.println(", and works for " + p.getCompany().getName() + 
                               " at " + p.getCompany().getLocation());
        }
    }
}
